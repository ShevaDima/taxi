package com.solvd.taxi.exceptions;

public class StringCharacterException extends Exception {
    public StringCharacterException() {
        super("StringCharacterException. Invalid character.");
    }

    public StringCharacterException(String message) {
        super(message);
    }
}
