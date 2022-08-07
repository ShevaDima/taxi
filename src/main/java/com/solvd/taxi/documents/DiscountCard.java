package com.solvd.taxi.documents;

import java.util.Objects;

public class DiscountCard implements IDocumentInfo {
    private int idNumber;
    private int discount;

    public DiscountCard() {
    }

    public DiscountCard(int idNumber, int discount) {
        this.idNumber = idNumber;
        this.discount = discount;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String printInfo() {
        return "Discount is " + getDiscount() + "%";
    }

    @Override
    public String getDocumentType() {
        return getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return getClass().getName() + "[idNumber=" + getIdNumber() + ",discount=" + getDiscount() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdNumber(), getDiscount());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountCard discountCard = (DiscountCard) o;
        return hashCode() == discountCard.hashCode();
    }
}
