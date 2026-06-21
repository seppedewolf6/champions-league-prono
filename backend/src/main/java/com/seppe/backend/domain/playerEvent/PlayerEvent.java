package com.seppe.backend.domain.playerEvent;

import java.time.LocalDateTime;
import java.util.UUID;

public class PlayerEvent {
    private UUID id;
    private UUID playerId;
    private UUID matchId;
    private EventType eventType;
    private double points;
    private int amount;
    private LocalDateTime createdAt;

    public PlayerEvent(UUID id, UUID playerId, UUID matchId, EventType eventType, double points, int amount, LocalDateTime createdAt) {
        this.id = id;
        this.playerId = playerId;
        this.matchId = matchId;
        this.eventType = eventType;
        this.points = points;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public void setPlayerId(UUID playerId) {
        this.playerId = playerId;
    }

    public UUID getMatchId() {
        return matchId;
    }

    public void setMatchId(UUID matchId) {
        this.matchId = matchId;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
