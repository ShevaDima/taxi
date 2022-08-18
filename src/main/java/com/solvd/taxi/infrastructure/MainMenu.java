package com.solvd.taxi.infrastructure;

import com.solvd.taxi.enums.Menu;
import com.solvd.taxi.exceptions.StringCharacterException;
import com.solvd.taxi.peoples.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    private final Logger log = LogManager.getLogger(TaxiApp.class);
    private final Scanner scanner = new Scanner(System.in);
    private Menu menu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void welcomeMenu() {
        log.info("Welcome to Taxi App");
        log.info("Do you have an account?");
        log.info("1. Yes");
        log.info("2. No");

        int ans;
        while (true) {
            try {
                ans = Integer.parseInt(scanner.nextLine());
                break;
            }
            catch (NumberFormatException e) {
                log.error(e.getMessage());
                log.info("Try one more time. Use only dedicated digits");
            }
        }

        switch (ans) {
            case 1:
                menu = Menu.OLDCLIENT;
                break;
            default:
                menu = Menu.NEWCLIENT;
                break;
        }

    }

    public void newClientMenu() {
        TaxiApp.createOrder();
    }

    public void oldClientMenu() {
        log.info("Select your account");
        log.info("Under development");
    }
}
