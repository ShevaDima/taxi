package com.solvd.taxi.placement;

import java.util.Objects;

public abstract class Location {
    private String city;
    private String street;
    private int house;

    public Location() {
    }

    public Location(String city, String street, int house) {
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[city=" + getCity() + ",street=" + getStreet() + ",house=" + getHouse() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity().hashCode(), getStreet().hashCode(), getHouse());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return hashCode() == location.hashCode();
    }
}
