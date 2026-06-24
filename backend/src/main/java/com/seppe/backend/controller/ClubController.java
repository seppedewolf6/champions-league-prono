package com.seppe.backend.controller;

import com.seppe.backend.dto.club.ClubRequest;
import com.seppe.backend.dto.club.ClubResponse;
import com.seppe.backend.dto.player.PlayerResponse;
import com.seppe.backend.service.ClubService;
import com.seppe.backend.service.PlayerService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/admin/clubs")
public class ClubController {

    private final ClubService clubService;
    private final PlayerService playerService;

    public ClubController(
            ClubService clubService,
            PlayerService playerService
    ) {
        this.clubService = clubService;
        this.playerService = playerService;
    }

    @GetMapping
    public List<ClubResponse> getAll() {
        return clubService.getAll();
    }

    @GetMapping("/{id}")
    public ClubResponse getById(
            @PathVariable UUID id
    ) {
        return clubService.getById(id);
    }

    @PostMapping
    public ClubResponse create(
            @RequestBody ClubRequest request
    ) {
        return clubService.create(request);
    }

    @PutMapping("/{id}")
    public ClubResponse update(
            @PathVariable UUID id,
            @RequestBody ClubRequest request
    ) {
        return clubService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable UUID id
    ) {
        clubService.delete(id);
    }

    @GetMapping("/club/{clubId}")
    public List<PlayerResponse> getByClub(
            @PathVariable UUID clubId
    ) {
        return playerService.getByClub(clubId);
    }
}
