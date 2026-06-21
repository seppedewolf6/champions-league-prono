package com.seppe.backend.domain;

import java.util.UUID;

public class TeamPlayer {
    private UUID id;
    private UUID team_id;
    private UUID player_id;
    private boolean is_starter;

    public TeamPlayer(UUID id, UUID team_id, UUID player_id, boolean is_starter) {
        this.id = id;
        this.team_id = team_id;
        this.player_id = player_id;
        this.is_starter = is_starter;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getTeam_id() {
        return team_id;
    }

    public void setTeam_id(UUID team_id) {
        this.team_id = team_id;
    }

    public UUID getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(UUID player_id) {
        this.player_id = player_id;
    }

    public boolean isIs_starter() {
        return is_starter;
    }

    public void setIs_starter(boolean is_starter) {
        this.is_starter = is_starter;
    }
}
