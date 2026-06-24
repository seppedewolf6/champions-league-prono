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
@Table(name = "teams", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id"})})
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "captain_player_id")
    private UUID captainPlayerId;

    @Column(nullable = false)
    private String teamName;

    @Column(nullable = false)
    private boolean locked;

    public Team() {}

    public Team(UUID id, UUID userId, UUID captainPlayerId, String teamName, boolean locked) {
        this.id = id;
        this.userId = userId;
        this.captainPlayerId = captainPlayerId;
        this.teamName = teamName;
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

    public void setCaptainPlayerId(UUID captainPlayerId) {
        this.captainPlayerId = captainPlayerId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
