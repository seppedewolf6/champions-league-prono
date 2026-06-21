package com.seppe.backend.domain;

import java.util.UUID;

public class CompetitionSettings {
    private UUID id;
    private boolean teamsLocked;
    private boolean substitutionsAllowed;
    private boolean teamsVisible;

    public CompetitionSettings(UUID id, boolean teamsLocked, boolean substitutionsAllowed, boolean teamsVisible) {
        this.id = id;
        this.teamsLocked = teamsLocked;
        this.substitutionsAllowed = substitutionsAllowed;
        this.teamsVisible = teamsVisible;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isTeamsLocked() {
        return teamsLocked;
    }

    public void setTeamsLocked(boolean teamsLocked) {
        this.teamsLocked = teamsLocked;
    }

    public boolean isSubstitutionsAllowed() {
        return substitutionsAllowed;
    }

    public void setSubstitutionsAllowed(boolean substitutionsAllowed) {
        this.substitutionsAllowed = substitutionsAllowed;
    }

    public boolean isTeamsVisible() {
        return teamsVisible;
    }

    public void setTeamsVisible(boolean teamsVisible) {
        this.teamsVisible = teamsVisible;
    }
}
