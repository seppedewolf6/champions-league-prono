package com.seppe.backend.mapper;

import com.seppe.backend.domain.user.User;
import com.seppe.backend.dto.login.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole()
        );
    }
}
