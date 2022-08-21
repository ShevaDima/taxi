package com.solvd.taxi;

import com.solvd.taxi.ReflectionTask.ReflectionTask;
import com.solvd.taxi.infrastructure.TaxiApp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        ReflectionTask reflectionTask = new ReflectionTask();

        //Getting field
        int number = 0;
        try {
            Field field = reflectionTask.getClass().getDeclaredField("number");
            field.setAccessible(true);
            field.set(reflectionTask, (int) 5);
            number = (int) field.get(reflectionTask);
        }
        catch (NoSuchFieldException | IllegalAccessException e) {
            log.error(e.getMessage());
        }
        log.info("Private field 'number' = " + number);

        //Getting method
        reflexionInfo(reflectionTask);

        //Main
        TaxiApp.startApp();
        TaxiApp.getAllClients();
    }

    public static void reflexionInfo(Object o) {
        try {
            Method method = o.getClass().getDeclaredMethod("info");
            method.setAccessible(true);
            method.invoke(o);
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            log.error(e.getMessage());
        }
    }
}
