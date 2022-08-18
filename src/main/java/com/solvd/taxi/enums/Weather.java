package com.solvd.taxi.enums;

public enum Weather {
    SUNNY("Sunny"),
    CLOUDY("Cloudy"),
    RAINY("Rainy");

    private String weather;

    Weather(String weather) {
        this.weather = weather;
    }

    public String getWeather() {
        return weather;
    }
}
