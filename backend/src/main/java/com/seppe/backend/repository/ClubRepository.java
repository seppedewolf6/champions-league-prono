package com.seppe.backend.repository;

import com.seppe.backend.domain.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClubRepository
        extends JpaRepository<Club, UUID> {

    Optional<Club> findByName(String name);
    boolean existsByName(String name);
}
