package com.solvd.taxi.peoples;

import java.util.Objects;

public class Dispatcher extends Employee implements IPeopleInfo, IEmployeeAccount {
    private boolean isRemote;

    public Dispatcher() {
    }

    public Dispatcher(String name, String surname, double salary, int experience, boolean isRemote) {
        super(name, surname, salary, experience);
        this.isRemote = isRemote;
    }

    public boolean getIsRemote() {
        return isRemote;
    }

    public void setIsRemote(boolean isRemote) {
        this.isRemote = isRemote;
    }

    @Override
    public String introduce() {
        return "I'm " + getName() + " " + getSurname() + ". I'm a dispatcher. Where are you going?";
    }

    @Override
    public String skills() {
        return "I'm a dispatcher. " + (getIsRemote() ? "I'm remote " : "I'm office ") + "worker";
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
        return getClass().getName() + "[name=" + getName() + ",surname=" + getSurname() + ",salary="
                + getSalary() + ",experience=" + getExperience() + ",isRemote=" + getIsRemote() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName().hashCode(), getSurname().hashCode(), getSalary(), getExperience(), getIsRemote());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dispatcher dispatcher = (Dispatcher) o;
        return hashCode() == dispatcher.hashCode();
    }
}
