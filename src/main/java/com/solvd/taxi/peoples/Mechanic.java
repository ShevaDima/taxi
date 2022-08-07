package com.solvd.taxi.peoples;;

import java.util.Objects;

public class Mechanic extends Employee implements IPeopleInfo, IEmployeeAccount {
    int rank;

    public Mechanic() {
    }

    public Mechanic(String name, String surname, double salary, int experience, int rank) {
        super(name, surname, salary, experience);
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String introduce() {
        return "I'm " + getName() + " " + getSurname() + ". I have " +
                getRank() + " rank of mastery!";
    }

    @Override
    public String skills() {
        return "I'm a mechanic. My experience is: " + super.getExperience() + " years";
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
                ",experience=" + getExperience() + ",rank=" + getRank() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName().hashCode(), getSurname().hashCode(), getSalary(), getExperience(),
                getRank());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic mechanic = (Mechanic) o;
        return hashCode() == mechanic.hashCode();
    }
}
