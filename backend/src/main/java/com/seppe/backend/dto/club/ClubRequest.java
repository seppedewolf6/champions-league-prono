package com.seppe.backend.dto.club;

public record ClubRequest(
        String name,
        int pot,
        double coefficient
) {}
