package com.solvd.taxi;

import com.solvd.taxi.infrastructure.CreateTaxi;
import com.solvd.taxi.peoples.*;

public class Main {

    public static void main(String[] args) {

        // Station init
        CreateTaxi taxiApp = new CreateTaxi();

        // Client init
        Client firstClient = taxiApp.initiateClient();

        // Order init
        taxiApp.initiateOrder(firstClient);
    }
}
