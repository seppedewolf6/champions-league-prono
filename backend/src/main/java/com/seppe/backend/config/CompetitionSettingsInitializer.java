package com.seppe.backend.config;

import com.seppe.backend.domain.CompetitionSettings;
import com.seppe.backend.repository.CompetitionSettingsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CompetitionSettingsInitializer
        implements CommandLineRunner {

    private final CompetitionSettingsRepository repository;

    public CompetitionSettingsInitializer(
            CompetitionSettingsRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {

        if (repository.count() == 0) {

            CompetitionSettings settings =
                    new CompetitionSettings();

            settings.setTeamsLocked(false);
            settings.setSubstitutionsAllowed(false);
            settings.setTeamsVisible(false);
            settings.setRegistrationsOpen(true);

            repository.save(settings);
        }
    }
}