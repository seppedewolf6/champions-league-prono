package com.seppe.backend.exception;

public class ClubAlreadyExistsException extends RuntimeException {
    public ClubAlreadyExistsException(String message) {
        super(message);
    }
}
