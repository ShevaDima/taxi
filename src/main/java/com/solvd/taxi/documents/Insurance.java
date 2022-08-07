package com.solvd.taxi.documents;

import java.util.Objects;

public class Insurance {
    private String companyName;
    private int insuranceSum;

    public Insurance() {
    }

    public Insurance(String companyName, int insuranceSum) {
        this.companyName = companyName;
        this.insuranceSum = insuranceSum;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getInsuranceSum() {
        return insuranceSum;
    }

    public void setInsuranceSum(int insuranceSum) {
        this.insuranceSum = insuranceSum;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[companyName=" + getCompanyName() + ",insuranceSum=" + getInsuranceSum() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCompanyName().hashCode(), getInsuranceSum());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insurance insurance = (Insurance) o;
        return hashCode() == insurance.hashCode();
    }
}
