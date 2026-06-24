package com.seppe.backend.service;

import com.seppe.backend.domain.Club;
import com.seppe.backend.dto.club.ClubRequest;
import com.seppe.backend.dto.club.ClubResponse;
import com.seppe.backend.exception.ClubAlreadyExistsException;
import com.seppe.backend.exception.ClubHasPlayersException;
import com.seppe.backend.exception.ClubNotFoundException;
import com.seppe.backend.mapper.ClubMapper;
import com.seppe.backend.repository.ClubRepository;
import com.seppe.backend.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ClubService {

    private final ClubRepository clubRepository;
private final PlayerRepository playerRepository;

    public ClubService(
            ClubRepository clubRepository,
            PlayerRepository playerRepository
    ) {
        this.clubRepository = clubRepository;
        this.playerRepository = playerRepository;
    }

    public List<ClubResponse> getAll() {
        return clubRepository.findAll()
                .stream()
                .map(ClubMapper::toResponse)
                .toList();
    }

    public ClubResponse getById(UUID id) {

        Club club = clubRepository.findById(id)
                .orElseThrow(() ->
                        new ClubNotFoundException(
                                "Club niet gevonden"
                        ));

        return ClubMapper.toResponse(club);
    }

    public ClubResponse create(
            ClubRequest request
    ) {

        if (clubRepository.existsByName(
                request.name())) {

            throw new ClubAlreadyExistsException(
                    "Club bestaat al"
            );
        }

        Club club = new Club();

        club.setName(request.name());
        club.setPot(request.pot());
        club.setCoefficient(request.coefficient());

        clubRepository.save(club);

        return ClubMapper.toResponse(club);
    }

    public ClubResponse update(
            UUID id,
            ClubRequest request
    ) {

        Club existingClub =
                clubRepository.findByName(request.name())
                        .orElse(null);

        if (existingClub != null &&
                !existingClub.getId().equals(id)) {

            throw new ClubAlreadyExistsException(
                    "Club bestaat al"
            );
        }

        Club club = clubRepository.findById(id)
                .orElseThrow(() ->
                        new ClubNotFoundException(
                                "Club niet gevonden"
                        ));

        club.setName(request.name());
        club.setPot(request.pot());
        club.setCoefficient(
                request.coefficient()
        );

        clubRepository.save(club);

        return ClubMapper.toResponse(club);
    }

    public void delete(UUID id) {

        if (!clubRepository.existsById(id)) {
            throw new ClubNotFoundException(
                    "Club niet gevonden"
            );
        }

        if (!playerRepository.findByClubId(id).isEmpty()) {
            throw new ClubHasPlayersException(
                    "Club bevat nog spelers"
            );
        }

        clubRepository.deleteById(id);
    }
}