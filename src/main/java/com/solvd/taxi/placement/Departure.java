package com.solvd.taxi.placement;

import java.util.Objects;

public class Departure extends Location implements ILocationInfo {
    private int porch;

    public Departure() {
    }

    public Departure(String city, String street, int house, int porch) {
        super(city, street, house);
        this.porch = porch;
    }

    public int getPorch() {
        return porch;
    }

    public void setPorch(int apartment) {
        this.porch = apartment;
    }

    @Override
    public String getLocation() {
        return getCity() + ", " + getStreet() + ", " + getHouse() + ", " + getPorch();
    }

    @Override
    public String toString() {
        return getClass().getName() + "[city=" + getCity() + ",street=" + getStreet() +
                ",house=" + getHouse() + ",porch=" + getPorch() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity().hashCode(), getStreet().hashCode(), getHouse(), getPorch());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departure departure = (Departure) o;
        return hashCode() == departure.hashCode();
    }
}
