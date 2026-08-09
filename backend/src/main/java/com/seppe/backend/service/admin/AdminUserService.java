package com.seppe.backend.service.admin;

import com.seppe.backend.domain.user.User;
import com.seppe.backend.dto.user.UnverifiedUserResponse;
import com.seppe.backend.exception.UserNotFoundException;
import com.seppe.backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AdminUserService {

    private final UserRepository userRepository;

    public AdminUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UnverifiedUserResponse> getUnverifiedUsers() {
        return userRepository.findByVerifiedFalse()
                .stream()
                .map(u -> new UnverifiedUserResponse(u.getId(), u.getUsername(), u.getEmail()))
                .toList();
    }

    public void verifyUser(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Gebruiker niet gevonden: " + userId));
        user.setVerified(true);
        userRepository.save(user);
    }
}