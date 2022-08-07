package com.solvd.taxi.infrastructure;

import com.solvd.taxi.documents.Insurance;
import com.solvd.taxi.documents.RegistrationCertificate;
import com.solvd.taxi.facility.Car;
import com.solvd.taxi.facility.Station;
import com.solvd.taxi.peoples.Dispatcher;
import com.solvd.taxi.peoples.Driver;
import com.solvd.taxi.peoples.Mechanic;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class FacilityGenerator {
    private static final String[] carManufacturer = {"Honda", "Nissan", "Tesla", "Mitsubishi", "Volvo", "Ford", "Jeep",
            "Volkswagen", "Hyundai", "Skoda", "KIA"};
    private static final String[] carModel = {"Accord", "Civic", "Juke", "Altima", "Model S", "Model 3", "Lancer",
            "Galant", "V50", "X60", "Transit", "Fusion", "Cherokee", "Compass", "Passat", "Golf", "Accent", "Elantra",
            "Superb", "Fabia", "Seed", "Sportage"};
    private static final String[] insuranceName = {"OneClick", "Salamandra", "VUSO", "Arsenal", "UNIQA",
            "INGO", "Oberig"};
    private static final String[] certificateType = {"Normal", "Premium", "Gold", "Platinum"};
    private static final String[] certificateNumber = {"FD78G128", "GNJ78G26", "BV571FD8", "YT478SD5", "JH4F56DF"};
    private static final String[] cityName = {"Kyiv", "Odessa", "Lviv", "Zhitomyr", "Dnipro", "Chernihiv"};
    private static final String[] streetName = {"Geroiv", "Volodymirska", "Kharkivska", "Lesi Ukrainki", "Central"};
    private static int stationId = 0;
    private static final Random random = new Random();

    public static Car createCar(Driver driver) {
        String manufacturer = carManufacturer[random.nextInt(carManufacturer.length)];
        String model = carModel[random.nextInt(carModel.length)];
        int horsePower = random.nextInt(350) + 100;

        return new Car(manufacturer, model, horsePower, randomInsurance(), randomCertificate(), driver);
    }

    public static Insurance randomInsurance() {
        String name = insuranceName[random.nextInt(insuranceName.length)];
        int insuranceSum = (random.nextInt(4000) + 1600) * 100;

        return new Insurance(name, insuranceSum);
    }
    public static RegistrationCertificate randomCertificate() {
        String type = certificateType[random.nextInt(certificateType.length)];
        String number = certificateNumber[random.nextInt(certificateNumber.length)];
        Calendar registrationDate = new GregorianCalendar(random.nextInt(22) + 2000,
                random.nextInt(12), random.nextInt(30) + 1);

        return new RegistrationCertificate(type, number, registrationDate);
    }

    public static Station createStation(Dispatcher dispatcher, Mechanic mechanic, Car[] cars) {
        String city = cityName[random.nextInt(cityName.length)];
        String street = streetName[random.nextInt(streetName.length)];
        stationId++;
        int house = random.nextInt(124) + 1;

        return new Station(city, street, stationId, house, dispatcher, mechanic, cars);
    }

}
