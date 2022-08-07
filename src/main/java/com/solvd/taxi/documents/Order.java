package com.solvd.taxi.documents;

import com.solvd.taxi.facility.Car;
import com.solvd.taxi.peoples.Client;
import com.solvd.taxi.peoples.Dispatcher;
import com.solvd.taxi.placement.Route;

import java.util.Objects;

public class Order {
    private int id;
    private Client client;
    private Car car;
    private Dispatcher dispatcher;
    private Route route;
    private Transaction transaction;

    public Order() {
    }

    public Order(int id, Client client, Car car, Dispatcher dispatcher, Route route, Transaction transaction) {
        this.id = id;
        this.client = client;
        this.car = car;
        this.dispatcher = dispatcher;
        this.route = route;
        this.transaction = transaction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[id=" + getId() + ",client=" + getClient().toString() + ",car=" +
                getCar().toString() + ",dispatcher=" + getDispatcher().toString() + ",route=" +
                getRoute().toString() + ",transaction=" + getTransaction().toString() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getClient().hashCode(), getCar().hashCode(), getDispatcher().hashCode(),
                getRoute().hashCode(), getTransaction().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return hashCode() == order.hashCode();
    }
}
