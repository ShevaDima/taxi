package com.solvd.taxi.peoples;

import com.solvd.taxi.documents.DiscountCard;

import java.util.Objects;

public class Client extends Person implements IPeopleInfo {
    private int id;
    private boolean hasDiscount;
    private DiscountCard discountCard;

    public Client() {
    }

    public Client(String name, String surname, int id, boolean hasDiscount) {
        super(name, surname);
        this.id = id;
        this.hasDiscount = hasDiscount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getHasDiscount() {
        return hasDiscount;
    }

    public void setHasDiscount(boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }

    public DiscountCard getDiscountCard() {
        return discountCard;
    }

    public void setDiscountCard(DiscountCard discountCard) {
        this.discountCard = discountCard;
    }

    @Override
    public String introduce() {
        return "I'm " + getName() + " " + getSurname() + ". Do I have a discount? " +
                (getHasDiscount() ? "Yes" : "No");
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
    public String toString() {
        return getClass().getName() + "[name=" + getName() + ",surname=" + getSurname() +
                ",id=" + getId() + ",hasDiscount=" + getHasDiscount() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName().hashCode(), getSurname().hashCode(), getId(), getHasDiscount());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return hashCode() == client.hashCode();
    }
}
