package com.solvd.taxi.documents;

import java.util.Calendar;
import java.util.Objects;

public class DriverLicense implements IDocumentInfo, IDateManager {
    private String category;
    private Calendar expireDate;

    public DriverLicense() {
    }

    public DriverLicense(String category, Calendar expireDate) {
        this.category = category;
        this.expireDate = expireDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Calendar getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Calendar expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String printInfo() {
        return "Driver license\nCategory: " + getCategory();
    }

    @Override
    public String getDocumentType() {
        return getClass().getSimpleName();
    }

    @Override
    public String printDate() {
        return "Expire date of driver license: " + getExpireDate().getTime();
    }

    @Override
    public String toString() {
        return getClass().getName() + "[category=" + getCategory() + ",expireDate=" + getExpireDate().getTime() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategory().hashCode(), getExpireDate().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverLicense driverLicense = (DriverLicense) o;
        return hashCode() == driverLicense.hashCode();
    }
}
