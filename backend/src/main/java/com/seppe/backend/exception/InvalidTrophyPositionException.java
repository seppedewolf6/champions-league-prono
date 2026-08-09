package com.seppe.backend.exception;

public class InvalidTrophyPositionException extends RuntimeException {
    public InvalidTrophyPositionException(String message) {
        super(message);
    }
}
