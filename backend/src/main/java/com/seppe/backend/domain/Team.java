package com.seppe.backend.domain;

import java.util.UUID;

public class Team {
    private UUID id;
    private UUID userId;
    private UUID captainPlayerId;
    private boolean locked;

    public Team(UUID id, UUID userId, UUID captainPlayerId, boolean locked) {
        this.id = id;
        this.userId = userId;
        this.captainPlayerId = captainPlayerId;
        this.locked = locked;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getCaptainPlayerId() {
        return captainPlayerId;
    }

    public void setCaptain_player_id(UUID captainPlayerId) {
        this.captainPlayerId = captainPlayerId;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
