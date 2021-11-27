package io.logizstikz.dronez.exception;

public class CarriageCapacityExceededException extends RuntimeException{
    public CarriageCapacityExceededException(String message) {
        super(message);
    }

    public CarriageCapacityExceededException(String message, Throwable cause) {
        super(message, cause);
    }
}
