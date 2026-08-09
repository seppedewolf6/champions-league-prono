package com.seppe.backend.controller.admin;

import com.seppe.backend.dto.score.*;
import com.seppe.backend.service.admin.AdminScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/admin/scores")
public class AdminScoreController {

    private final AdminScoreService adminScoreService;

    public AdminScoreController(AdminScoreService adminScoreService) {
        this.adminScoreService = adminScoreService;
    }

    @GetMapping("/clubs")
    public List<ClubResponse> searchClubs(@RequestParam(required = false) String search) {
        return adminScoreService.searchClubs(search);
    }

    @GetMapping("/clubs/{clubId}/players")
    public List<PlayerForScoringResponse> getPlayersForClub(@PathVariable UUID clubId) {
        return adminScoreService.getPlayersForClub(clubId);
    }

    @PostMapping("/players/{playerId}")
    public PlayerScoreResponse addScore(
            @PathVariable UUID playerId,
            @RequestBody PlayerScoreRequest request
    ) {
        return adminScoreService.addScore(playerId, request);
    }

    @PutMapping("/{scoreId}")
    public PlayerScoreResponse updateScore(
            @PathVariable UUID scoreId,
            @RequestBody PlayerScoreRequest request
    ) {
        return adminScoreService.updateScore(scoreId, request);
    }

    @DeleteMapping("/{scoreId}")
    public void deleteScore(@PathVariable UUID scoreId) {
        adminScoreService.deleteScore(scoreId);
    }
}