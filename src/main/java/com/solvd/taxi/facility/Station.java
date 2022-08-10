package com.solvd.taxi.facility;

import com.solvd.taxi.peoples.Dispatcher;
import com.solvd.taxi.peoples.Mechanic;
import com.solvd.taxi.placement.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Station extends Location {
    private int id;
    private Dispatcher dispatcher;
    private Mechanic mechanic;
    private List<Car> cars = new ArrayList<>();

    public Station() {
    }

    public Station(String city, String street, int id, int house, Dispatcher dispatcher, Mechanic mechanic,
                   List<Car> cars) {
        super(city, street, house);
        this.id = id;
        this.dispatcher = dispatcher;
        this.mechanic = mechanic;
        this.cars = cars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[city=" + getCity() + ",street=" + getStreet() + ",id=" + getId() + ",house=" +
                getHouse() + ",dispatcher=" + getDispatcher().toString() +
                ",mechanic=" + getMechanic().toString() + ",Cars=" + cars.toString() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity().hashCode(), getStreet().hashCode(), getId(), getHouse(),
                getDispatcher().hashCode(), getMechanic().hashCode(), getCars().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return hashCode() == station.hashCode();
    }
}
