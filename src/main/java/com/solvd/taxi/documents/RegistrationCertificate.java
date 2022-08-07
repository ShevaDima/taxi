package com.solvd.taxi.documents;

import java.util.Calendar;
import java.util.Objects;

public class RegistrationCertificate implements IDocumentInfo, IDateManager {
    private String type;
    private String number;
    private Calendar registrationDate;

    public RegistrationCertificate() {
    }

    public RegistrationCertificate(String type, String number, Calendar registrationDate) {
        this.type = type;
        this.number = number;
        this.registrationDate = registrationDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Calendar getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Calendar registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String printInfo() {
        return "Registration certificate #" + getNumber() + "\nType: " + getType();
    }

    @Override
    public String getDocumentType() {
        return getClass().getSimpleName();
    }

    @Override
    public String printDate() {
        return "Registration date is " + getRegistrationDate().getTime();
    }

    @Override
    public String toString() {
        return getClass().getName() + "[type=" + getType() + ",number=" + getNumber() + ",registrationDate=" +
                getRegistrationDate().getTime() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getNumber(), getRegistrationDate().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationCertificate registrationCertificate = (RegistrationCertificate) o;
        return hashCode() == registrationCertificate.hashCode();
    }
}
