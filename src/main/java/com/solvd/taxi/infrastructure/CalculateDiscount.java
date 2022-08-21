package com.solvd.taxi.infrastructure;

@FunctionalInterface
public interface CalculateDiscount {
    double discountSum(double cost, double discount);
}
