package com.seppe.backend.repository.projection;

import java.util.UUID;

public interface RankingProjection {
    UUID getTeamId();
    String getTeamName();
    String getUsername();
    Double getTotalPoints();
}