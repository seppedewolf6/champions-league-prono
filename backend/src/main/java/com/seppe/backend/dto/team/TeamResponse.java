package com.seppe.backend.dto.team;

import java.util.List;
import java.util.UUID;

public record TeamResponse(
        UUID id,
        String teamName,
        boolean locked,
        List<TeamPlayerResponse> players
) {}