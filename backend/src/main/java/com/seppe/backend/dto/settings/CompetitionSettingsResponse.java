package com.seppe.backend.dto.settings;

import java.util.UUID;

public record CompetitionSettingsResponse(
        UUID id,
        boolean teamsLocked,
        boolean substitutionsAllowed,
        boolean teamsVisible,
        boolean registrationsOpen
) {}