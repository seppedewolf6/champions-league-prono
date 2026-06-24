package com.seppe.backend.service;

import com.seppe.backend.domain.CompetitionSettings;
import com.seppe.backend.domain.user.User;
import com.seppe.backend.domain.user.UserRole;
import com.seppe.backend.dto.login.AuthResponse;
import com.seppe.backend.dto.login.LoginRequest;
import com.seppe.backend.dto.login.RegisterRequest;
import com.seppe.backend.exception.InvalidCredentialsException;
import com.seppe.backend.exception.RegistrationClosedException;
import com.seppe.backend.exception.UserAlreadyExistsException;
import com.seppe.backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthService {
    private final UserRepository userRepository;
    private final CompetitionSettingsService competitionSettingsService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            UserRepository userRepository,
            CompetitionSettingsService competitionSettingsService,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.userRepository = userRepository;
        this.competitionSettingsService = competitionSettingsService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponse register(RegisterRequest request) {

        CompetitionSettings settings =
                competitionSettingsService.getSettings();

        if (!settings.isRegistrationsOpen()) {
            throw new RegistrationClosedException(
                    "Registraties zijn gesloten"
            );
        }

        if (userRepository.existsByEmail(request.email())) {
            throw new UserAlreadyExistsException("Email already exists");
        }

        if (userRepository.existsByUsername(request.username())) {
            throw new UserAlreadyExistsException("Username already exists");
        }

        User user = new User(
                null,
                request.username(),
                request.email(),
                passwordEncoder.encode(request.password()),
                true,
                UserRole.USER
        );

        userRepository.save(user);

        String token = jwtService.generateToken(user);

        return new AuthResponse(
                token,
                user.getUsername(),
                user.getRole().name()
        );
    }

    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.email())
                .orElseThrow(InvalidCredentialsException::new);

        if (!passwordEncoder.matches(
                request.password(),
                user.getPassword())) {

            throw new InvalidCredentialsException();
        }

        String token = jwtService.generateToken(user);

        return new AuthResponse(
                token,
                user.getUsername(),
                user.getRole().name()
        );
    }
}


