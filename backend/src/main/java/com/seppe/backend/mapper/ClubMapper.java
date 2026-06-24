package com.seppe.backend.mapper;

import com.seppe.backend.domain.Club;
import com.seppe.backend.dto.club.ClubResponse;

public class ClubMapper {

    private ClubMapper() {}

    public static ClubResponse toResponse(
            Club club
    ) {
        return new ClubResponse(
                club.getId(),
                club.getName(),
                club.getPot(),
                club.getCoefficient()
        );
    }
}