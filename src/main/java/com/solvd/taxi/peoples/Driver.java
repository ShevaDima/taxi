package com.solvd.taxi.peoples;

import com.solvd.taxi.documents.DriverLicense;

import java.util.Objects;

public class Driver extends Employee implements IPeopleInfo, IEmployeeAccount {
    private double rating;
    private DriverLicense driverLicense;

    public Driver() {
    }

    public Driver(String name, String surname, double salary, int experience, double rating,
                  DriverLicense driverLicense) {
        super(name, surname, salary, experience);
        this.rating = rating;
        this.driverLicense = driverLicense;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public DriverLicense getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(DriverLicense driverLicense) {
        this.driverLicense = driverLicense;
    }

    @Override
    public String introduce() {
        return "I'm " + getName() + " " + getSurname();
    }

    @Override
    public String skills() {
        return "I'm a driver. My experience is: " + getExperience() + " years";
    }

    @Override
    public String printBio() {
        return getName() + " " + getSurname();
    }

    @Override
    public boolean isEmployee() {
        return Employee.class.isAssignableFrom(getClass());
    }

    @Override
    public void increaseSalary(double multiplier) {
        setSalary(getSalary() * multiplier);
    }

    @Override
    public void decreaseSalary(double multiplier) {
        setSalary(getSalary() / multiplier);
    }

    @Override
    public String getEmployeeType() {
        return getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + getName() + ",surname=" + getSurname() + ",salary=" + getSalary() +
                ",experience=" + getExperience() + ",rating=" + getRating() + ",driverLicense=" +
                getDriverLicense().toString() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName().hashCode(), getSurname().hashCode(), getSalary(), getExperience(), getRating(),
                getDriverLicense().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return hashCode() == driver.hashCode();
    }
}
