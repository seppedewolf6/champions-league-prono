package com.seppe.backend.controller;

import com.seppe.backend.domain.user.User;
import com.seppe.backend.dto.team.TeamResponse;
import com.seppe.backend.repository.UserRepository;
import com.seppe.backend.service.TeamService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;
    private final UserRepository userRepository;

    public TeamController(
            TeamService teamService,
            UserRepository userRepository
    ) {
        this.teamService = teamService;
        this.userRepository = userRepository;
    }

    @GetMapping("/me")
    public TeamResponse getMyTeam(Authentication authentication) {

        User user = userRepository.findByEmail(authentication.getName())
                .orElseThrow();

        return teamService.getMyTeam(user);
    }
}