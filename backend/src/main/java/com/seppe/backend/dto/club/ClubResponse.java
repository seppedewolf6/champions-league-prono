package com.seppe.backend.dto.club;

import java.util.UUID;

public record ClubResponse(
        UUID id,
        String name,
        int pot,
        double coefficient
) {}
