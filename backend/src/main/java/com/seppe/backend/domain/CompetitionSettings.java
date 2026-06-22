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


    public CompetitionSettings() {}

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
