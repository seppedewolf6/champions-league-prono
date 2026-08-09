package com.seppe.backend.controller.admin;

import com.seppe.backend.dto.user.UnverifiedUserResponse;
import com.seppe.backend.service.admin.AdminUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/admin/users")
public class AdminUserController {

    private final AdminUserService adminUserService;

    public AdminUserController(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    @GetMapping("/unverified")
    public List<UnverifiedUserResponse> getUnverifiedUsers() {
        return adminUserService.getUnverifiedUsers();
    }

    @PostMapping("/{userId}/verify")
    public void verifyUser(@PathVariable UUID userId) {
        adminUserService.verifyUser(userId);
    }
}