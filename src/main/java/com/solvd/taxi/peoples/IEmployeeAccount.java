package com.solvd.taxi.peoples;

public interface IEmployeeAccount {
    void increaseSalary(double multiplier);

    void decreaseSalary(double multiplier);

    String getEmployeeType();
}
