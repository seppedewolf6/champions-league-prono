package com.seppe.backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.UUID;

@Entity
@Table(name = "team_players", uniqueConstraints = {@UniqueConstraint(columnNames = {"team_id", "player_id"})})
public class TeamPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "team_id", nullable = false)
    private UUID teamId;

    @Column(name = "player_id", nullable = false)
    private UUID playerId;

    @Column(name = "is_starter", nullable = false)
    private boolean isStarter;

    public TeamPlayer() {
    }

    public TeamPlayer(UUID id, UUID teamId, UUID playerId, boolean isStarter) {
        this.id = id;
        this.teamId = teamId;
        this.playerId = playerId;
        this.isStarter = isStarter;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public void setTeamId(UUID teamId) {
        this.teamId = teamId;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public void setPlayerId(UUID playerId) {
        this.playerId = playerId;
    }

    public boolean isStarter() {
        return isStarter;
    }

    public void setStarter(boolean starter) {
        this.isStarter = starter;
    }
}
