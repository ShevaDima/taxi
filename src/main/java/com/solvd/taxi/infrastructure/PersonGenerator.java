package com.solvd.taxi.infrastructure;

import com.solvd.taxi.documents.DiscountCard;
import com.solvd.taxi.documents.DriverLicense;
import com.solvd.taxi.peoples.Client;
import com.solvd.taxi.peoples.Dispatcher;
import com.solvd.taxi.peoples.Driver;
import com.solvd.taxi.peoples.Mechanic;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class PersonGenerator {
    private static final String[] employeeName = {"Bob", "Bill", "Susan", "Alex", "Nathan", "Mary", "Donald", "Nancy",
            "John", "Rose", "Alex", "Mitch"};
    private static final String[] employeeSurname = {"Smith", "Johnson", "Williams", "Gibson", "Davis", "Grant",
            "Jackson", "Abrams", "MacDonald", "Parkinson"};
    private static int clientId = 0;

    private static final Random random = new Random();

    public static Dispatcher createDispatcher() {
        String name = employeeName[random.nextInt(employeeName.length)];
        String surname = employeeSurname[random.nextInt(employeeSurname.length)];
        double salary = Math.round(random.nextDouble() * 12000) + 10000;
        int experience = random.nextInt(19) + 1;
        boolean isRemote = random.nextBoolean();

        return new Dispatcher(name, surname, salary, experience, isRemote);
    }

    public static Mechanic createMechanic() {
        String name = employeeName[random.nextInt(employeeName.length)];
        String surname = employeeSurname[random.nextInt(employeeSurname.length)];
        double salary = Math.round(random.nextDouble() * 8000) + 7000;
        int experience = random.nextInt(26) + 1;
        int rank = random.nextInt(5) + 1;

        return new Mechanic(name, surname, salary, experience, rank);
    }

    public static Driver createDriver() {
        String name = employeeName[random.nextInt(employeeName.length)];
        String surname = employeeSurname[random.nextInt(employeeSurname.length)];
        double salary = Math.round(random.nextDouble() * 15000) + 12000;
        int experience = random.nextInt(10) + 1;
        double rating = Math.round((random.nextDouble() * 2.0 + 3.0) * 10.0) / 10.0;
        String category = "B";
        Calendar expireDate = new GregorianCalendar(random.nextInt(28) + 2023,
                random.nextInt(12), random.nextInt(30) + 1);
        DriverLicense driverLicense = new DriverLicense(category, expireDate);

        return new Driver(name, surname, salary, experience, rating, driverLicense);
    }

    public static Client createClient(String name, String surname) {
        clientId++;
        boolean hasDiscount = random.nextBoolean();
        Client client = new Client(name, surname, clientId, hasDiscount);
        if (hasDiscount) {
            DiscountCard discountCard = new DiscountCard(client.getId(), random.nextInt(10) + 5);
            client.setDiscountCard(discountCard);
        }

        return client;
    }
}
