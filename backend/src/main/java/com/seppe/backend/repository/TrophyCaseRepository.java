package com.seppe.backend.repository;

import com.seppe.backend.domain.trophyCase.TrophyCase;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface TrophyCaseRepository extends JpaRepository<TrophyCase, UUID> {
    Optional<TrophyCase> findByPosition(int position);
}