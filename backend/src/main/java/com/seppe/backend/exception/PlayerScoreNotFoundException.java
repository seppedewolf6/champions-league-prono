package com.seppe.backend.exception;

public class PlayerScoreNotFoundException extends RuntimeException {
    public PlayerScoreNotFoundException(String message) {
        super(message);
    }
}
