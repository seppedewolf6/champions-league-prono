package com.seppe.backend.service.admin;

import com.seppe.backend.domain.trophyCase.TrophyCase;
import com.seppe.backend.dto.trophyCase.TrophyCaseEntryRequest;
import com.seppe.backend.dto.trophyCase.TrophyCaseEntryResponse;
import com.seppe.backend.exception.InvalidTrophyPositionException;
import com.seppe.backend.repository.TrophyCaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TrophyCaseService {

    private final TrophyCaseRepository trophyCaseRepository;

    public TrophyCaseService(TrophyCaseRepository trophyCaseRepository) {
        this.trophyCaseRepository = trophyCaseRepository;
    }

    public List<TrophyCaseEntryResponse> getTrophyCase() {
        return trophyCaseRepository.findAll()
                .stream()
                .sorted((a, b) -> Integer.compare(a.getPosition(), b.getPosition()))
                .map(t -> new TrophyCaseEntryResponse(t.getPosition(), t.getPhotoUrl(), t.getName()))
                .toList();
    }

    public TrophyCaseEntryResponse setEntry(int position, TrophyCaseEntryRequest request) {
        if (position < 1 || position > 3) {
            throw new InvalidTrophyPositionException("Positie moet 1, 2 of 3 zijn: " + position);
        }

        TrophyCase entry = trophyCaseRepository.findByPosition(position)
                .orElseGet(TrophyCase::new);

        entry.setPosition(position);
        entry.setPhotoUrl(request.photoUrl());
        entry.setName(request.name());

        trophyCaseRepository.save(entry);

        return new TrophyCaseEntryResponse(entry.getPosition(), entry.getPhotoUrl(), entry.getName());
    }
}