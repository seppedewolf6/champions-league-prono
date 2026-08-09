package com.seppe.backend.repository;

import com.seppe.backend.domain.playerScore.TeamPlayerScore;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface TeamPlayerScoreRepository extends JpaRepository<TeamPlayerScore, UUID> {
    List<TeamPlayerScore> findByPlayerScoreId(UUID playerScoreId);
}