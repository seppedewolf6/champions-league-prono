package com.seppe.backend.controller.admin;

import com.seppe.backend.dto.settings.CompetitionSettingsResponse;
import com.seppe.backend.service.admin.AdminSettingsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/settings")
public class AdminSettingsController {

    private final AdminSettingsService adminSettingsService;

    public AdminSettingsController(AdminSettingsService adminSettingsService) {
        this.adminSettingsService = adminSettingsService;
    }

    @GetMapping
    public CompetitionSettingsResponse getSettings() {
        return adminSettingsService.getCurrentSettings();
    }

    @PostMapping("/teams-lock/toggle")
    public CompetitionSettingsResponse toggleTeamsLocked() {
        return adminSettingsService.toggleTeamsLocked();
    }
}