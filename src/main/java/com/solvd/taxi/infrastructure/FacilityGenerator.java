package com.solvd.taxi.infrastructure;

import com.solvd.taxi.documents.Insurance;
import com.solvd.taxi.documents.RegistrationCertificate;
import com.solvd.taxi.facility.Car;
import com.solvd.taxi.facility.Station;
import com.solvd.taxi.peoples.Dispatcher;
import com.solvd.taxi.peoples.Driver;
import com.solvd.taxi.peoples.Mechanic;

import java.util.*;

public class FacilityGenerator {
    private static final List<String> carManufacturer = new ArrayList<>() {
        {
            add("Honda");
            add("Nissan");
            add("Tesla");
            add("Mitsubishi");
            add("Volvo");
            add("Ford");
            add("Jeep");
            add("Volkswagen");
            add("Hyundai");
            add("Skoda");
            add("KIA");
        }
    };
    private static final List<String> carModel = new ArrayList<>() {
        {
            add("Accord");
            add("Civic");
            add("Juke");
            add("Altima");
            add("Model S");
            add("Model 3");
            add("Lancer");
            add("Galant");
            add("V50");
            add("X60");
            add("Transit");
            add("Fusion");
            add("Cherokee");
            add("Compass");
            add("Passat");
            add("Golf");
            add("Accent");
            add("Elantra");
            add("Superb");
            add("Fabia");
            add("Seed");
            add("Sportage");
        }
    };
    private static final List<String> insuranceName = new ArrayList<>() {
        {
            add("OneClick");
            add("Salamandra");
            add("VUSO");
            add("Arsenal");
            add("UNIQA");
            add("INGO");
            add("Oberig");
        }
    };
    private static final List<String> certificateType = new ArrayList<>() {
        {
            add("Normal");
            add("Premium");
            add("Gold");
            add("Platinum");
        }
    };
    private static final List<String> certificateNumber = new ArrayList<>() {
        {
            add("FD78G128");
            add("GNJ78G26");
            add("BV571FD8");
            add("YT478SD5");
            add("JH4F56DF");
        }
    };
    private static final List<String> cityName = new ArrayList<>() {
        {
            add("Kyiv");
            add("Odessa");
            add("Lviv");
            add("Zhitomyr");
            add("Dnipro");
            add("Chernihiv");
        }
    };
    private static final List<String> streetName = new ArrayList<>() {
        {
            add("Geroiv");
            add("Volodymirska");
            add("Kharkivska");
            add("Lesi Ukrainki");
            add("Central");
        }
    };
    private static int stationId = 0;
    private static final Random random = new Random();

    public static Car createCar(Driver driver) {
        String manufacturer = carManufacturer.get(random.nextInt(carManufacturer.size()));
        String model = carModel.get(random.nextInt(carModel.size()));
        int horsePower = random.nextInt(350) + 100;

        return new Car(manufacturer, model, horsePower, randomInsurance(), randomCertificate(), driver);
    }

    public static Insurance randomInsurance() {
        String name = insuranceName.get(random.nextInt(insuranceName.size()));
        int insuranceSum = (random.nextInt(4000) + 1600) * 100;

        return new Insurance(name, insuranceSum);
    }
    public static RegistrationCertificate randomCertificate() {
        String type = certificateType.get(random.nextInt(certificateType.size()));
        String number = certificateNumber.get(random.nextInt(certificateNumber.size()));
        Calendar registrationDate = new GregorianCalendar(random.nextInt(22) + 2000,
                random.nextInt(12), random.nextInt(30) + 1);

        return new RegistrationCertificate(type, number, registrationDate);
    }

    public static Station createStation(Dispatcher dispatcher, Mechanic mechanic, List<Car> cars) {
        String city = cityName.get(random.nextInt(cityName.size()));
        String street = streetName.get(random.nextInt(streetName.size()));
        stationId++;
        int house = random.nextInt(124) + 1;

        return new Station(city, street, stationId, house, dispatcher, mechanic, cars);
    }

}
