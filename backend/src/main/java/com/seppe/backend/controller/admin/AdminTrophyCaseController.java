package com.seppe.backend.controller.admin;

import com.seppe.backend.dto.trophyCase.TrophyCaseEntryRequest;
import com.seppe.backend.dto.trophyCase.TrophyCaseEntryResponse;
import com.seppe.backend.service.admin.TrophyCaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/trophy-case")
public class AdminTrophyCaseController {

    private final TrophyCaseService trophyCaseService;

    public AdminTrophyCaseController(TrophyCaseService trophyCaseService) {
        this.trophyCaseService = trophyCaseService;
    }

    @GetMapping
    public List<TrophyCaseEntryResponse> getTrophyCase() {
        return trophyCaseService.getTrophyCase();
    }

    @PutMapping("/{position}")
    public TrophyCaseEntryResponse setEntry(
            @PathVariable int position,
            @RequestBody TrophyCaseEntryRequest request
    ) {
        return trophyCaseService.setEntry(position, request);
    }
}