package com.seppe.backend.exception;

public class ClubHasPlayersException extends RuntimeException {
    public ClubHasPlayersException(String message) {
        super(message);
    }
}
