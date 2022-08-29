package com.solvd.taxi.ReflectionTask;

import com.solvd.taxi.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReflectionTask {
    private static final Logger log = LogManager.getLogger(Main.class);
    private int number;
    private String name = "Taxi";

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void info() {
        log.info(number + " " + name);
    }
}
