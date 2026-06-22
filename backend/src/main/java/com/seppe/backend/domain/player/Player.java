package com.seppe.backend.domain.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "club_id", nullable = false)
    private UUID clubId;

    @Column(name = "external_api_id")
    private UUID externalApiId;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "player_position", nullable = false, length = 20)
    private PlayerPosition playerPosition;

    public Player() {}

    public Player(UUID id, UUID clubId, UUID externalApiId, String name, PlayerPosition position) {
        this.id = id;
        this.clubId = clubId;
        this.externalApiId = externalApiId;
        this.name = name;
        this.playerPosition = position;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getClubId() {
        return clubId;
    }

    public void setClubId(UUID clubId) {
        this.clubId = clubId;
    }

    public UUID getExternalApiId() {
        return externalApiId;
    }

    public void setExternalApiId(UUID externalApiId) {
        this.externalApiId = externalApiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerPosition getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(PlayerPosition playerPosition) {
        this.playerPosition = playerPosition;
    }
}
