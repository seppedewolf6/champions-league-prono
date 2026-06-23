package com.seppe.backend.repository;

import com.seppe.backend.domain.CompetitionSettings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompetitionSettingsRepository
        extends JpaRepository<CompetitionSettings, UUID> {
}