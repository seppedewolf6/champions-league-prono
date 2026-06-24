package com.seppe.backend.repository;

import com.seppe.backend.domain.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PlayerRepository
        extends JpaRepository<Player, UUID> {

    List<Player> findByClubId(UUID clubId);
}
