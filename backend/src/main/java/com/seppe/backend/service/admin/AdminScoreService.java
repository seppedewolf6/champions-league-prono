package com.seppe.backend.service.admin;

import com.seppe.backend.domain.TeamPlayer;
import com.seppe.backend.domain.player.Player;
import com.seppe.backend.domain.playerScore.PlayerScore;
import com.seppe.backend.domain.playerScore.TeamPlayerScore;
import com.seppe.backend.dto.score.*;
import com.seppe.backend.exception.ClubNotFoundException;
import com.seppe.backend.exception.PlayerNotFoundException;
import com.seppe.backend.exception.PlayerScoreNotFoundException;
import com.seppe.backend.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AdminScoreService {

    private final ClubRepository clubRepository;
    private final PlayerRepository playerRepository;
    private final TeamPlayerRepository teamPlayerRepository;
    private final PlayerScoreRepository playerScoreRepository;
    private final TeamPlayerScoreRepository teamPlayerScoreRepository;

    public AdminScoreService(
            ClubRepository clubRepository,
            PlayerRepository playerRepository,
            TeamPlayerRepository teamPlayerRepository,
            PlayerScoreRepository playerScoreRepository,
            TeamPlayerScoreRepository teamPlayerScoreRepository
    ) {
        this.clubRepository = clubRepository;
        this.playerRepository = playerRepository;
        this.teamPlayerRepository = teamPlayerRepository;
        this.playerScoreRepository = playerScoreRepository;
        this.teamPlayerScoreRepository = teamPlayerScoreRepository;
    }

    public List<ClubResponse> searchClubs(String search) {
        List<com.seppe.backend.domain.Club> clubs = (search == null || search.isBlank())
                ? clubRepository.findAll()
                : clubRepository.findByNameContainingIgnoreCase(search);

        return clubs.stream()
                .map(c -> new ClubResponse(c.getId(), c.getName()))
                .toList();
    }

    public List<PlayerForScoringResponse> getPlayersForClub(UUID clubId) {
        if (!clubRepository.existsById(clubId)) {
            throw new ClubNotFoundException("Club niet gevonden: " + clubId);
        }

        return playerRepository.findPlayersInAnyTeamByClubId(clubId)
                .stream()
                .map(p -> new PlayerForScoringResponse(p.getId(), p.getName(), p.getPlayerPosition().name()))
                .toList();
    }

    public PlayerScoreResponse addScore(UUID playerId, PlayerScoreRequest request) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException("Speler niet gevonden: " + playerId));

        PlayerScore playerScore = new PlayerScore();
        playerScore.setPlayer(player);
        playerScore.setPoints(request.points());
        playerScore.setCreatedAt(LocalDateTime.now());
        playerScoreRepository.save(playerScore);

        List<TeamPlayer> activeInTeams = teamPlayerRepository.findByPlayerIdAndIsStarterTrue(playerId);

        for (TeamPlayer teamPlayer : activeInTeams) {
            TeamPlayerScore credit = new TeamPlayerScore();
            credit.setTeamPlayer(teamPlayer);
            credit.setPlayerScore(playerScore);
            credit.setPoints(request.points());
            teamPlayerScoreRepository.save(credit);
        }

        return toResponse(playerScore, activeInTeams.size());
    }

    public PlayerScoreResponse updateScore(UUID scoreId, PlayerScoreRequest request) {
        PlayerScore playerScore = playerScoreRepository.findById(scoreId)
                .orElseThrow(() -> new PlayerScoreNotFoundException("Score niet gevonden: " + scoreId));

        playerScore.setPoints(request.points());
        playerScoreRepository.save(playerScore);

        // Wie krediet kreeg ligt vast (bevroren op moment van toekenning) — enkel het bedrag wijzigt.
        List<TeamPlayerScore> credits = teamPlayerScoreRepository.findByPlayerScoreId(scoreId);
        credits.forEach(c -> c.setPoints(request.points()));
        teamPlayerScoreRepository.saveAll(credits);

        return toResponse(playerScore, credits.size());
    }

    public void deleteScore(UUID scoreId) {
        PlayerScore playerScore = playerScoreRepository.findById(scoreId)
                .orElseThrow(() -> new PlayerScoreNotFoundException("Score niet gevonden: " + scoreId));

        List<TeamPlayerScore> credits = teamPlayerScoreRepository.findByPlayerScoreId(scoreId);
        teamPlayerScoreRepository.deleteAll(credits);
        playerScoreRepository.delete(playerScore);
    }

    private PlayerScoreResponse toResponse(PlayerScore playerScore, int teamsCredited) {
        return new PlayerScoreResponse(
                playerScore.getId(),
                playerScore.getPlayer().getId(),
                playerScore.getPoints(),
                playerScore.getCreatedAt(),
                teamsCredited
        );
    }
}