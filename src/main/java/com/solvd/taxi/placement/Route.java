package com.solvd.taxi.placement;

import com.solvd.taxi.exceptions.LocationException;

import java.util.Objects;

public class Route {
    private static final double rate = 1.7;
    private Arrival arrival;
    private Departure departure;
    private double distance;
    private double routeCost;

    public Route() {
    }

    public Route(Arrival arrival, Departure departure, double distance) throws LocationException {
        if ((arrival.getCity()).equals(departure.getCity()) && (arrival.getStreet()).equals(departure.getStreet())
        && (arrival.getHouse() == departure.getHouse())) {
            throw new LocationException();
        }
        this.arrival = arrival;
        this.departure = departure;
        this.distance = distance;
        this.routeCost = (double) Math.round(getRate() * getDistance() * 100) / 100;
    }

    public Arrival getArrival() {
        return arrival;
    }

    public void setArrival(Arrival arrival) {
        this.arrival = arrival;
    }

    public Departure getDeparture() {
        return departure;
    }

    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public static double getRate() {
        return rate;
    }

    public double getRouteCost() {
        return routeCost;
    }

    public void setRouteCost(double routeCost) {
        this.routeCost = routeCost;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[arrival=" + getArrival().toString() + ",Departure=" +
                getDeparture().toString() + ",distance=" + getDistance() + ",routeCost=" + getRouteCost() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArrival().hashCode(), getDeparture().hashCode(), getDistance(),
                getRouteCost());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return hashCode() == route.hashCode();
    }
}
