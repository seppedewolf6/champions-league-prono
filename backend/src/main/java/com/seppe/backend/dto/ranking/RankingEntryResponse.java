package com.seppe.backend.dto.ranking;

public record RankingEntryResponse(
        String username,
        String teamName,
        double totalPoints
) {}