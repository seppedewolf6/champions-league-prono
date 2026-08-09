package com.seppe.backend.repository;

import com.seppe.backend.domain.Team;
import com.seppe.backend.repository.projection.RankingProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TeamRepository extends JpaRepository<Team, UUID> {
    Optional<Team> findByUserId(UUID userId);

    // TeamRepository - toevoegen
    @Query("""
    SELECT t.id AS teamId, t.teamName AS teamName, u.username AS username,
           COALESCE(SUM(tps.points), 0) AS totalPoints
    FROM Team t
    JOIN t.user u
    LEFT JOIN TeamPlayer tp ON tp.team = t
    LEFT JOIN TeamPlayerScore tps ON tps.teamPlayer = tp
    GROUP BY t.id, t.teamName, u.username
    ORDER BY totalPoints DESC
    """)
    List<RankingProjection> findRanking();
}