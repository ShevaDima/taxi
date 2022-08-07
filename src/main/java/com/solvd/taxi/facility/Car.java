package com.solvd.taxi.facility;

import com.solvd.taxi.documents.Insurance;
import com.solvd.taxi.documents.RegistrationCertificate;
import com.solvd.taxi.peoples.Driver;

import java.util.Objects;

public class Car {
    private String manufacturer;
    private String model;
    private int horsePower;
    private Insurance insurance;
    private RegistrationCertificate registrationCertificate;
    private Driver driver;

    public Car() {
    }

    public Car(String manufacturer, String model, int horsePower, Insurance insurance,
               RegistrationCertificate registrationCertificate, Driver driver) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.horsePower = horsePower;
        this.insurance = insurance;
        this.registrationCertificate = registrationCertificate;
        this.driver = driver;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public RegistrationCertificate getRegistrationCertificate() {
        return registrationCertificate;
    }

    public void setRegistrationCertificate(RegistrationCertificate registrationCertificate) {
        this.registrationCertificate = registrationCertificate;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[manufacturer=" + getManufacturer() + ",model=" + getModel() + ",horsePower="
                + getHorsePower() + ",insurance=" + getInsurance().toString() + ",registrationCertificate=" +
                getRegistrationCertificate() + ",driver=" + getDriver().toString() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getManufacturer().hashCode(), getModel().hashCode(), getHorsePower(),
                getInsurance().hashCode(), getRegistrationCertificate().hashCode(), getDriver().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return hashCode() == car.hashCode();
    }
}
