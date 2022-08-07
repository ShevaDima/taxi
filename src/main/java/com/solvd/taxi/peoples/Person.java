package com.solvd.taxi.peoples;

import java.util.Objects;

public abstract class Person {
    private String name;
    private String surname;

    public Person() {
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public abstract String introduce();

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + getName() + ",surname=" + getSurname() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName().hashCode(), getSurname().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return hashCode() == person.hashCode();
    }
}
