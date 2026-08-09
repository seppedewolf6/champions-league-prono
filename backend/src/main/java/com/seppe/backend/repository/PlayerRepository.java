package com.seppe.backend.repository;

import com.seppe.backend.domain.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PlayerRepository
        extends JpaRepository<Player, UUID> {

    List<Player> findByClubId(UUID clubId);

    // PlayerRepository - toevoegen
    @Query("SELECT DISTINCT p FROM Player p JOIN TeamPlayer tp ON tp.player = p WHERE p.club.id = :clubId")
    List<Player> findPlayersInAnyTeamByClubId(@Param("clubId") UUID clubId);
}
