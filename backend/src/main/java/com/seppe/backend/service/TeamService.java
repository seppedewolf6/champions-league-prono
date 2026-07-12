package com.seppe.backend.service;

import com.seppe.backend.domain.Team;
import com.seppe.backend.domain.TeamPlayer;
import com.seppe.backend.domain.user.User;
import com.seppe.backend.dto.team.TeamResponse;
import com.seppe.backend.exception.TeamNotFoundException;
import com.seppe.backend.mapper.TeamMapper;
import com.seppe.backend.repository.TeamPlayerRepository;
import com.seppe.backend.repository.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TeamService {

    private final TeamRepository teamRepository;
    private final TeamPlayerRepository teamPlayerRepository;

    public TeamService(
            TeamRepository teamRepository,
            TeamPlayerRepository teamPlayerRepository
    ) {
        this.teamRepository = teamRepository;
        this.teamPlayerRepository = teamPlayerRepository;
    }

    public TeamResponse getMyTeam(User currentUser) {

        Team team = teamRepository.findByUserId(currentUser.getId())
                .orElseThrow(() ->
                        new TeamNotFoundException("Je hebt nog geen team")
                );

        List<TeamPlayer> teamPlayers =
                teamPlayerRepository.findByTeamId(team.getId());

        return TeamMapper.toResponse(team, teamPlayers);
    }
}