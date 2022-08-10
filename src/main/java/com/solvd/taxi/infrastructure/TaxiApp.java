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

import java.util.*;

public class TaxiApp {
    private static final Logger log = LogManager.getLogger(TaxiApp.class);
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final Dispatcher dispatcher = PersonGenerator.createDispatcher();
    private static final Mechanic mechanic = PersonGenerator.createMechanic();
    private static final Driver firstDriver = PersonGenerator.createDriver();
    private static final Driver secondDriver = PersonGenerator.createDriver();
    private static final Driver thirdDriver = PersonGenerator.createDriver();
    private static final Driver fourthDriver = PersonGenerator.createDriver();
    private static final Car firstCar = FacilityGenerator.createCar(firstDriver);
    private final static Car secondCar = FacilityGenerator.createCar(secondDriver);
    private final static Car thirdCar = FacilityGenerator.createCar(thirdDriver);
    private final static Car fourthCar = FacilityGenerator.createCar(fourthDriver);
    private final static List<Car> cars = new ArrayList<>() {
        {
            add(firstCar);
            add(secondCar);
            add(thirdCar);
            add(fourthCar);
        }

    };
    private final static Station station = FacilityGenerator.createStation(dispatcher, mechanic, cars);
    private final static Map<Integer, Client> clients= new HashMap<>();

    public static Client initiateClient() {
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

    public static void initiateOrder(Client client) {
        RouteCreator routeCreator = new RouteCreator();
        Departure clientDeparture = routeCreator.createDeparture();
        Arrival clientArrival = routeCreator.createArrival();

        Route route = routeCreator.createRoute(clientDeparture, clientArrival);

        Transaction transaction = new Transaction(client.getId(), client.getHasDiscount() ?
                (Math.round((route.getRouteCost() - (route.getRouteCost() * client.getDiscountCard().getDiscount() /
                        100.0)) * 100.0) / 100.0) : route.getRouteCost());

        Order order = new Order(client.getId(), client,
                station.getCars().get(random.nextInt(station.getCars().size())),
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

    public static void createOrder() {
        Client client = initiateClient();
        clients.put(client.getId(), client);
        initiateOrder(client);
    }

    public static void getAllClients() {
        log.info(clients.toString());
    }

}
