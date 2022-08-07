package com.solvd.taxi.exceptions;

public class NegativeNumberException extends Exception {
    public NegativeNumberException() {
        super("NegativeNumberException. Number should be positive");
    }

    public NegativeNumberException(String message) {
        super(message);
    }
}
