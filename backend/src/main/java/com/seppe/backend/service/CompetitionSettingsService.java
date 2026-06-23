package com.seppe.backend.service;

import com.seppe.backend.domain.CompetitionSettings;
import com.seppe.backend.repository.CompetitionSettingsRepository;
import org.springframework.stereotype.Service;

@Service
public class CompetitionSettingsService {

    private final CompetitionSettingsRepository repository;

    public CompetitionSettingsService(
            CompetitionSettingsRepository repository
    ) {
        this.repository = repository;
    }

    public CompetitionSettings getSettings() {

        return repository.findAll()
                .stream()
                .findFirst()
                .orElseThrow(() ->
                        new IllegalStateException(
                                "Competition settings ontbreken"
                        )
                );
    }
}
