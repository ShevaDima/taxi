package com.solvd.taxi.infrastructure;

import com.solvd.taxi.exceptions.LocationException;
import com.solvd.taxi.exceptions.NegativeNumberException;
import com.solvd.taxi.exceptions.StringCharacterException;
import com.solvd.taxi.placement.Arrival;
import com.solvd.taxi.placement.Departure;
import com.solvd.taxi.placement.Route;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.Scanner;

public class RouteCreator {
    private static final Logger log = LogManager.getLogger(RouteCreator.class);
    private static final Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    public Departure createDeparture() {
        // Departure City
        log.info("Your current location: \nEnter city: ");
        String departureCity;
        try {
            departureCity = scanner.nextLine();
            if (!departureCity.matches("^[A-Za-z\\s]+$")) {
                throw new StringCharacterException("Only 'space' character, capital and small letters are allowed");
            }
        }
        catch (StringCharacterException e) {
            do {
                log.error(e.getMessage());
                log.info("Try one more time");
                departureCity = scanner.nextLine();
            } while (!departureCity.matches("^[A-Za-z\\s]+$"));
        }

        // Departure Street
        log.info("Enter street: ");
        String departureStreet;
        try {
            departureStreet = scanner.nextLine();
            if (!departureStreet.matches("^[A-Za-z\\s]+$")) {
                throw new StringCharacterException("Only 'space' character, capital and small letters are allowed");
            }
        }
        catch (StringCharacterException e) {
            do {
                log.error(e.getMessage());
                log.info("Try one more time");
                departureStreet = scanner.nextLine();
            } while (!departureStreet.matches("^[A-Za-z\\s]+$"));
        }

        // Departure House
        log.info("Enter house: ");
        int departureHouse;
        while (true) {
            try {
                departureHouse = Integer.parseInt(scanner.nextLine());
                try {
                    if (departureHouse < 1) {
                        throw new NegativeNumberException();
                    }
                }
                catch (NegativeNumberException e)  {
                    log.error(e.getMessage());
                    log.info("Try one more time");
                    continue;
                }
                break;
            }
            catch (NumberFormatException e) {
                log.error(e.getMessage());
                log.info("Try one more time");
            }
        }

        // Departure Porch
        log.info("Enter porch: ");
        int departurePorch;
        while (true) {
            try {
                departurePorch = Integer.parseInt(scanner.nextLine());
                try {
                    if (departurePorch < 1) {
                        throw new NegativeNumberException();
                    }
                }
                catch (NegativeNumberException e)  {
                    log.error(e.getMessage());
                    log.info("Try one more time");
                    continue;
                }
                break;
            }
            catch (NumberFormatException e) {
                log.error(e.getMessage());
                log.info("Try one more time");
            }
        }

        // Departure Init
        return new Departure(departureCity, departureStreet, departureHouse, departurePorch);

    }

    public Arrival createArrival() {
        // Arrival City
        log.info("Your arrival location: \nEnter city: ");
        String arrivalCity;
        try {
            arrivalCity = scanner.nextLine();
            if (!arrivalCity.matches("^[A-Za-z\\s]+$")) {
                throw new StringCharacterException("Only 'space' character, capital and small letters are allowed");
            }
        }
        catch (StringCharacterException e) {
            do {
                log.error(e.getMessage());
                log.info("Try one more time");
                arrivalCity = scanner.nextLine();
            } while (!arrivalCity.matches("^[A-Za-z\\s]+$"));
        }

        // Arrival Street
        log.info("Enter street: ");
        String arrivalStreet;
        try {
            arrivalStreet = scanner.nextLine();
            if (!arrivalStreet.matches("^[A-Za-z\\s]+$")) {
                throw new StringCharacterException("Only 'space' character, capital and small letters are allowed");
            }
        }
        catch (StringCharacterException e) {
            do {
                log.error(e.getMessage());
                log.info("Try one more time");
                arrivalStreet = scanner.nextLine();
            } while (!arrivalStreet.matches("^[A-Za-z\\s]+$"));
        }

        // Arrival House
        log.info("Enter house: ");
        int arrivalHouse;
        while (true) {
            try {
                arrivalHouse = Integer.parseInt(scanner.nextLine());
                try {
                    if (arrivalHouse < 1) {
                        throw new NegativeNumberException();
                    }
                }
                catch (NegativeNumberException e)  {
                    log.error(e.getMessage());
                    log.info("Try one more time");
                    continue;
                }
                break;
            }
            catch (NumberFormatException e) {
                log.error(e.getMessage());
                log.info("Try one more time");
            }
        }

        // Arrival Porch
        log.info("Enter apartment: ");
        int arrivalApartment;
        while (true) {
            try {
                arrivalApartment = Integer.parseInt(scanner.nextLine());
                try {
                    if (arrivalApartment < 1) {
                        throw new NegativeNumberException();
                    }
                }
                catch (NegativeNumberException e)  {
                    log.error(e.getMessage());
                    log.info("Try one more time");
                    continue;
                }
                break;
            }
            catch (NumberFormatException e) {
                log.error(e.getMessage());
                log.info("Try one more time");
            }
        }

        // Arrival Init
        return new Arrival(arrivalCity, arrivalStreet, arrivalHouse, arrivalApartment);
    }

    public Route createRoute(Departure departure, Arrival arrival) {
        Route route;
        while (true) {
            try {
                route = new Route(arrival, departure, random.nextInt(70) + 10);
                break;
            }
            catch (LocationException e) {
                log.error(e.getMessage());
                log.info("Your arrival and departure locations are the same");
                departure = createDeparture();
                arrival = createArrival();
            }
        }
        return route;
    }
}
