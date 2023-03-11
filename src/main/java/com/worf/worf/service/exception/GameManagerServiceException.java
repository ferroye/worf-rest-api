package com.worf.worf.service.exception;

public class GameManagerServiceException extends RuntimeException {
    public GameManagerServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
