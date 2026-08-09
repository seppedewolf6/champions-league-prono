package com.seppe.backend.service;

import com.seppe.backend.dto.ranking.RankingEntryResponse;
import com.seppe.backend.repository.TeamRepository;
import com.seppe.backend.repository.projection.RankingProjection;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RankingService {

    private final TeamRepository teamRepository;

    public RankingService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<RankingEntryResponse> getRanking() {
        List<RankingProjection> projections = teamRepository.findRanking();

        return projections.stream()
                .map(p -> new RankingEntryResponse(p.getUsername(), p.getTeamName(), p.getTotalPoints()))
                .toList();
    }
}