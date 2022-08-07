package com.solvd.taxi.infrastructure;

import com.solvd.taxi.documents.Order;
import com.solvd.taxi.documents.Transaction;
import com.solvd.taxi.exceptions.StringCharacterException;
import com.solvd.taxi.facility.Car;
import com.solvd.taxi.facility.Station;
import com.solvd.taxi.peoples.*;
import com.solvd.taxi.placement.Arrival;
import com.solvd.taxi.placement.Departure;
import com.solvd.taxi.placement.Route;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.Scanner;

public class CreateTaxi {
    private static final Logger log = LogManager.getLogger(CreateTaxi.class);
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private final Dispatcher dispatcher = PersonGenerator.createDispatcher();
    private final Mechanic mechanic = PersonGenerator.createMechanic();
    private final Driver firstDriver = PersonGenerator.createDriver();
    private final Driver secondDriver = PersonGenerator.createDriver();
    private final Driver thirdDriver = PersonGenerator.createDriver();
    private final Driver fourthDriver = PersonGenerator.createDriver();
    private final Car firstCar = FacilityGenerator.createCar(firstDriver);
    private final Car secondCar = FacilityGenerator.createCar(secondDriver);
    private final Car thirdCar = FacilityGenerator.createCar(thirdDriver);
    private final Car fourthCar = FacilityGenerator.createCar(fourthDriver);
    private final Car[] cars = new Car[] {firstCar, secondCar, thirdCar, fourthCar};
    private final Station station = FacilityGenerator.createStation(dispatcher, mechanic, cars);

    public Client initiateClient() {
        // Dialogue start
        log.info("Welcome to Taxi App\nEnter your first name: ");

        String clientName;
        try {
            clientName = scanner.nextLine();
            if (!clientName.matches("[a-zA-Z]+")) {
                throw new StringCharacterException();
            }
        }
        catch (StringCharacterException e) {
            do {
                log.error(e.getMessage());
                log.info("Try one more time. Use only capital and small letters");
                clientName = scanner.nextLine();
            } while (!clientName.matches("[a-zA-Z]+"));
        }

        log.info("Enter your surname: ");

        String clientSurname;
        try {
            clientSurname = scanner.nextLine();
            if (!clientSurname.matches("[a-zA-Z]+")) {
                throw new StringCharacterException();
            }
        }
        catch (StringCharacterException e) {
            do {
                log.error(e.getMessage());
                log.info("Try one more time. Use only capital and small letters");
                clientSurname = scanner.nextLine();
            } while (!clientSurname.matches("[a-zA-Z]+"));
        }

        // Client init
        Client client = PersonGenerator.createClient(clientName, clientSurname);

        // Dialogue
        log.info(client.introduce());
        log.info(station.getDispatcher().introduce());

        return client;
    }

    public void initiateOrder(Client client) {
        RouteCreator routeCreator = new RouteCreator();
        Departure clientDeparture = routeCreator.createDeparture();
        Arrival clientArrival = routeCreator.createArrival();

        Route route = routeCreator.createRoute(clientDeparture, clientArrival);

        Transaction transaction = new Transaction(client.getId(), client.getHasDiscount() ?
                (Math.round((route.getRouteCost() - (route.getRouteCost() * client.getDiscountCard().getDiscount() /
                        100.0)) * 100.0) / 100.0) : route.getRouteCost());

        Order order = new Order(client.getId(), client,
                station.getCars()[random.nextInt(station.getCars().length)],
                station.getDispatcher(), route, transaction);

        log.info("Thanks for your order! \n" +
                "============================================================\n" +
                "Order details: \n" +
                "\tOrder number: " + order.getId() + "\n" +
                "\tYour position: " + order.getRoute().getDeparture().getLocation() + "\n" +
                "\tDriving to: " + order.getRoute().getArrival().getLocation() + "\n" +
                "\tCar: " + order.getCar().getManufacturer() + " " + order.getCar().getModel() + "\n" +
                "\t\tDriver: " + order.getCar().getDriver().printBio() + "\n" +
                "\t\tRating: " + order.getCar().getDriver().getRating() + "\n" +
                "\n" +
                "\tRoute cost: " + order.getRoute().getRouteCost() + "\n" +
                (client.getHasDiscount() ? "\t\tIncluding your " + client.getDiscountCard().getDiscount() +
                        "% discount: \n" +
                        "\t\tTotal: " + order.getTransaction().getAmount() + "\n" : "") +
                "============================================================");
    }

}
