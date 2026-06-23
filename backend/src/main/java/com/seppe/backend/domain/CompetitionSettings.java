package com.seppe.backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "competition_settings")
public class CompetitionSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "teams_locked", nullable = false)
    private boolean teamsLocked;

    @Column(name = "substitutions_allowed", nullable = false)
    private boolean substitutionsAllowed;

    @Column(name = "teams_visible", nullable = false)
    private boolean teamsVisible;

    @Column(name = "registrations_open", nullable = false)
    private boolean registrationsOpen;

    public CompetitionSettings() {
        this.teamsLocked = false;
        this.substitutionsAllowed = false;
        this.teamsVisible = false;
        this.registrationsOpen = true;
    }

    public CompetitionSettings(UUID id, boolean teamsLocked, boolean substitutionsAllowed, boolean teamsVisible, boolean registrationsOpen) {
        this.id = id;
        this.teamsLocked = teamsLocked;
        this.substitutionsAllowed = substitutionsAllowed;
        this.teamsVisible = teamsVisible;
        this.registrationsOpen = registrationsOpen;
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

    public boolean isRegistrationsOpen() {
        return registrationsOpen;
    }

    public void setRegistrationsOpen(boolean registrationsOpen) {
        this.registrationsOpen = registrationsOpen;
    }
}
