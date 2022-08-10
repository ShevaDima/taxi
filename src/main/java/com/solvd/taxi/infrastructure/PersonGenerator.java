package com.solvd.taxi.infrastructure;

import com.solvd.taxi.documents.DiscountCard;
import com.solvd.taxi.documents.DriverLicense;
import com.solvd.taxi.peoples.Client;
import com.solvd.taxi.peoples.Dispatcher;
import com.solvd.taxi.peoples.Driver;
import com.solvd.taxi.peoples.Mechanic;

import java.util.*;

public class PersonGenerator {
    private static final List<String> employeeName = new ArrayList<>() {
        {
            add("Bob");
            add("Bill");
            add("Susan");
            add("Alex");
            add("Nathan");
            add("Mary");
            add("Donald");
            add("Nancy");
            add("John");
            add("Rose");
            add("Alex");
            add("Mitch");
        }
    };
    private static final List<String> employeeSurname = new ArrayList<>() {
        {
            add( "Smith");
            add("Johnson");
            add("Williams");
            add("Gibson");
            add("Davis");
            add("Grant");
            add("Jackson");
            add("Abrams");
            add("MacDonald");
            add("Parkinson");
        }
    };
    private static int clientId = 0;

    private static final Random random = new Random();

    public static Dispatcher createDispatcher() {
        String name = employeeName.get(random.nextInt(employeeName.size()));
        String surname = employeeSurname.get(random.nextInt(employeeSurname.size()));
        double salary = Math.round(random.nextDouble() * 12000) + 10000;
        int experience = random.nextInt(19) + 1;
        boolean isRemote = random.nextBoolean();

        return new Dispatcher(name, surname, salary, experience, isRemote);
    }

    public static Mechanic createMechanic() {
        String name = employeeName.get(random.nextInt(employeeName.size()));
        String surname = employeeSurname.get(random.nextInt(employeeSurname.size()));
        double salary = Math.round(random.nextDouble() * 8000) + 7000;
        int experience = random.nextInt(26) + 1;
        int rank = random.nextInt(5) + 1;

        return new Mechanic(name, surname, salary, experience, rank);
    }

    public static Driver createDriver() {
        String name = employeeName.get(random.nextInt(employeeName.size()));
        String surname = employeeSurname.get(random.nextInt(employeeSurname.size()));
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
