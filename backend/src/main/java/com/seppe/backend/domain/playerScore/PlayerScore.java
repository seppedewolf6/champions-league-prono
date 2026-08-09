package com.seppe.backend.domain.playerScore;

import com.seppe.backend.domain.player.Player;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "player_scores")
public class PlayerScore {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @Column(nullable = false)
    private double points;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public PlayerScore() {}

    public PlayerScore(UUID id, Player player, double points, LocalDateTime createdAt) {
        this.id = id;
        this.player = player;
        this.points = points;
        this.createdAt = createdAt;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }
    public double getPoints() { return points; }
    public void setPoints(double points) { this.points = points; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}