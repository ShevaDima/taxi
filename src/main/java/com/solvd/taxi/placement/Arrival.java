package com.solvd.taxi.placement;

import java.util.Objects;

public class Arrival extends Location implements ILocationInfo {
    private int apartment;

    public Arrival() {
    }

    public Arrival(String city, String street, int house, int apartment) {
        super(city, street, house);
        this.apartment = apartment;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    @Override
    public String getLocation() {
        return getCity() + ", " + getStreet() + ", " + getHouse() + ", " + getApartment();
    }

    @Override
    public String toString() {
        return getClass().getName() + "[city=" + getCity() + ",street=" + getStreet() +
                ",house=" + getHouse() + ",apartment=" + getApartment() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity().hashCode(), getStreet().hashCode(), getHouse(), getApartment());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arrival arrival = (Arrival) o;
        return hashCode() == arrival.hashCode();
    }
}
