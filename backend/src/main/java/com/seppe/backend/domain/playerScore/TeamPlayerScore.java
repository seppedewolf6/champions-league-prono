package com.seppe.backend.domain.playerScore;

import com.seppe.backend.domain.TeamPlayer;
import jakarta.persistence.*;
import java.util.UUID;

/**
 * Bevriest, op het moment dat een PlayerScore wordt toegekend, welke teams
 * er krediet voor krijgen (enkel teams waar de speler op dat moment isStarter=true was).
 * Latere wijzigingen aan isStarter hebben geen invloed op reeds bestaande records hier.
 */
@Entity
@Table(name = "team_player_scores", uniqueConstraints = {@UniqueConstraint(columnNames = {"team_player_id", "player_score_id"})})
public class TeamPlayerScore {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_player_id", nullable = false)
    private TeamPlayer teamPlayer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_score_id", nullable = false)
    private PlayerScore playerScore;

    @Column(nullable = false)
    private double points;

    public TeamPlayerScore() {}

    public TeamPlayerScore(UUID id, TeamPlayer teamPlayer, PlayerScore playerScore, double points) {
        this.id = id;
        this.teamPlayer = teamPlayer;
        this.playerScore = playerScore;
        this.points = points;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public TeamPlayer getTeamPlayer() { return teamPlayer; }
    public void setTeamPlayer(TeamPlayer teamPlayer) { this.teamPlayer = teamPlayer; }
    public PlayerScore getPlayerScore() { return playerScore; }
    public void setPlayerScore(PlayerScore playerScore) { this.playerScore = playerScore; }
    public double getPoints() { return points; }
    public void setPoints(double points) { this.points = points; }
}