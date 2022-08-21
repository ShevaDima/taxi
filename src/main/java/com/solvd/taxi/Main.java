package com.solvd.taxi;

import com.solvd.taxi.StringTask.StringTask;
import com.solvd.taxi.infrastructure.MainMenu;
import com.solvd.taxi.infrastructure.TaxiApp;

public class Main {

    public static void main(String[] args) {

        TaxiApp.startApp();
        TaxiApp.getAllClients();
    }
}
