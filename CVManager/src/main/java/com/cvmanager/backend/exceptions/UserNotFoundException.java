package com.cvmanager.backend.exceptions;

public class UserNotFoundException extends Exception {

    private static final long serialVersionId = 1l;

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
