package com.seppe.backend.service;

import com.seppe.backend.domain.Club;
import com.seppe.backend.domain.player.Player;
import com.seppe.backend.dto.player.PlayerRequest;
import com.seppe.backend.dto.player.PlayerResponse;
import com.seppe.backend.exception.ClubNotFoundException;
import com.seppe.backend.exception.PlayerNotFoundException;
import com.seppe.backend.mapper.PlayerMapper;
import com.seppe.backend.repository.ClubRepository;
import com.seppe.backend.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final ClubRepository clubRepository;

    public PlayerService(
            PlayerRepository playerRepository,
            ClubRepository clubRepository
    ) {
        this.playerRepository = playerRepository;
        this.clubRepository = clubRepository;
    }

    public List<PlayerResponse> getAll() {

        return playerRepository.findAll()
                .stream()
                .map(PlayerMapper::toResponse)
                .toList();
    }

    public PlayerResponse getById(UUID id) {

        Player player = playerRepository.findById(id)
                .orElseThrow(() ->
                        new PlayerNotFoundException(
                                "Speler niet gevonden"
                        ));

        return PlayerMapper.toResponse(player);
    }

    public PlayerResponse create(
            PlayerRequest request
    ) {

        Club club = clubRepository.findById(
                        request.clubId())
                .orElseThrow(() ->
                        new ClubNotFoundException(
                                "Club niet gevonden"
                        ));

        Player player = new Player();

        player.setClub(club);
        player.setExternalApiId(
                request.externalApiId()
        );
        player.setName(request.name());
        player.setPlayerPosition(
                request.playerPosition()
        );

        playerRepository.save(player);

        return PlayerMapper.toResponse(player);
    }

    public PlayerResponse update(
            UUID id,
            PlayerRequest request
    ) {

        Player player = playerRepository.findById(id)
                .orElseThrow(() ->
                        new PlayerNotFoundException(
                                "Speler niet gevonden"
                        ));

        Club club = clubRepository.findById(
                        request.clubId())
                .orElseThrow(() ->
                        new ClubNotFoundException(
                                "Club niet gevonden"
                        ));

        player.setClub(club);
        player.setExternalApiId(
                request.externalApiId()
        );
        player.setName(request.name());
        player.setPlayerPosition(
                request.playerPosition()
        );

        playerRepository.save(player);

        return PlayerMapper.toResponse(player);
    }

    public void delete(UUID id) {

        if (!playerRepository.existsById(id)) {

            throw new PlayerNotFoundException(
                    "Speler niet gevonden"
            );
        }

        playerRepository.deleteById(id);
    }

    public List<PlayerResponse> getByClub(
            UUID clubId
    ) {
        return playerRepository.findByClubId(clubId)
                .stream()
                .map(PlayerMapper::toResponse)
                .toList();
    }
}