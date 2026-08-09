package com.seppe.backend.controller;

import com.seppe.backend.dto.ranking.RankingEntryResponse;
import com.seppe.backend.service.RankingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ranking")
public class RankingController {

    private final RankingService rankingService;

    public RankingController(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    @GetMapping
    public List<RankingEntryResponse> getRanking() {
        return rankingService.getRanking();
    }
}