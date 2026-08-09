package com.seppe.backend.repository;

import com.seppe.backend.domain.playerScore.PlayerScore;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PlayerScoreRepository extends JpaRepository<PlayerScore, UUID> {
}