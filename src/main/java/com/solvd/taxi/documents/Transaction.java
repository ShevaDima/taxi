package com.solvd.taxi.documents;

import java.util.Objects;

public class Transaction {
    private int id;
    private double amount;

    public Transaction() {
    }

    public Transaction(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[id=" + getId() + ",amount=" + getAmount() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAmount());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction transaction = (Transaction) o;
        return hashCode() == transaction.hashCode();
    }
}
