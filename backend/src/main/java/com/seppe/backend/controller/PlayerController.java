package com.seppe.backend.controller;

import com.seppe.backend.dto.player.PlayerRequest;
import com.seppe.backend.dto.player.PlayerResponse;
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
@RequestMapping("/api/admin/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(
            PlayerService playerService
    ) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<PlayerResponse> getAll() {
        return playerService.getAll();
    }

    @GetMapping("/{id}")
    public PlayerResponse getById(
            @PathVariable UUID id
    ) {
        return playerService.getById(id);
    }

    @PostMapping
    public PlayerResponse create(
            @RequestBody PlayerRequest request
    ) {
        return playerService.create(request);
    }

    @PutMapping("/{id}")
    public PlayerResponse update(
            @PathVariable UUID id,
            @RequestBody PlayerRequest request
    ) {
        return playerService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable UUID id
    ) {
        playerService.delete(id);
    }
}