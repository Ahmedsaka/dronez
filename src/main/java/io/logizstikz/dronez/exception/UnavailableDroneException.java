package io.logizstikz.dronez.exception;

public class UnavailableDroneException extends RuntimeException {
    public UnavailableDroneException(String message) {
        super(message);
    }

    public UnavailableDroneException(String message, Throwable cause) {
        super(message, cause);
    }
}
