package com.solvd.taxi.exceptions;

public class LocationException extends Exception {
    public LocationException() {
        super("LocationException. Wrong location");
    }

    public LocationException(String message) {
        super(message);
    }
}
