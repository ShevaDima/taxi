package com.solvd.taxi.peoples;

import java.util.Objects;

public abstract class Employee extends Person {
    private double salary;
    private int experience;

    public Employee() {
    }

    public Employee(double salary, int experience) {
        this.salary = salary;
        this.experience = experience;
    }

    public Employee(String name, String surname, double salary, int experience) {
        super(name, surname);
        this.salary = salary;
        this.experience = experience;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public abstract String skills();

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + getName() + ",surname=" + getSurname() + ",salary=" + getSalary() +
                ",experience=" + getExperience() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName().hashCode(), getSurname().hashCode(), getSalary(), getExperience());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return hashCode() == employee.hashCode();
    }
}
