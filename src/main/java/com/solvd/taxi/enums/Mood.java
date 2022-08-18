package com.solvd.taxi.enums;

public enum Mood {
    HAPPY("Happy"),
    SAD("Sad"),
    SURPRISED("Surprised");

    private String mood;

    Mood(String mood) {
        this.mood = mood;
    }

    public String getMood() {
        return mood;
    }
}
