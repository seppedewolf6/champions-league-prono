package com.seppe.backend.repository;

import com.seppe.backend.domain.TeamPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TeamPlayerRepository extends JpaRepository<TeamPlayer, UUID> {
    List<TeamPlayer> findByTeamId(UUID teamId);
}