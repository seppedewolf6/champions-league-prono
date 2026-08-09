package com.seppe.backend.service.admin;

import com.seppe.backend.domain.CompetitionSettings;
import com.seppe.backend.dto.settings.CompetitionSettingsResponse;
import com.seppe.backend.repository.CompetitionSettingsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AdminSettingsService {

    private final CompetitionSettingsRepository competitionSettingsRepository;

    public AdminSettingsService(CompetitionSettingsRepository competitionSettingsRepository) {
        this.competitionSettingsRepository = competitionSettingsRepository;
    }

    private CompetitionSettings getSettings() {
        // Er is exact 1 rij settings; wordt aangemaakt als ze nog niet bestaat.
        return competitionSettingsRepository.findAll()
                .stream()
                .findFirst()
                .orElseGet(() -> competitionSettingsRepository.save(new CompetitionSettings()));
    }

    public CompetitionSettingsResponse toggleTeamsLocked() {
        CompetitionSettings settings = getSettings();
        settings.setTeamsLocked(!settings.isTeamsLocked());
        competitionSettingsRepository.save(settings);
        return toResponse(settings);
    }

    public CompetitionSettingsResponse getCurrentSettings() {
        return toResponse(getSettings());
    }

    private CompetitionSettingsResponse toResponse(CompetitionSettings s) {
        return new CompetitionSettingsResponse(
                s.getId(), s.isTeamsLocked(), s.isSubstitutionsAllowed(),
                s.isTeamsVisible(), s.isRegistrationsOpen()
        );
    }
}