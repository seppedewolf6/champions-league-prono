package com.seppe.backend.mapper;

import com.seppe.backend.domain.Team;
import com.seppe.backend.domain.TeamPlayer;
import com.seppe.backend.dto.team.TeamPlayerResponse;
import com.seppe.backend.dto.team.TeamResponse;

import java.util.List;

public class TeamMapper {

    private TeamMapper() {}

    public static TeamResponse toResponse(
            Team team,
            List<TeamPlayer> teamPlayers
    ) {

        List<TeamPlayerResponse> players = teamPlayers.stream()
                .map(TeamMapper::toPlayerResponse)
                .toList();

        return new TeamResponse(
                team.getId(),
                team.getTeamName(),
                team.isLocked(),
                players
        );
    }

    private static TeamPlayerResponse toPlayerResponse(TeamPlayer teamPlayer) {

        return new TeamPlayerResponse(
                teamPlayer.getId(),
                teamPlayer.getPlayer().getId(),
                teamPlayer.getPlayer().getName(),
                teamPlayer.getPlayer().getClub().getName(),
                teamPlayer.getPlayer().getPlayerPosition(),
                teamPlayer.isStarter()
        );
    }
}