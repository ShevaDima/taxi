package com.solvd.taxi.externalTasks.threadPool;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool implements Runnable {
    private String name;

    public ThreadPool(String name) {
        this.name = name;
    }

    public String getTaskName() {
        return name;
    }

    //Task
    public void run() {
        try {
            System.out.println("Executing Task: " + name);
            Thread.sleep(2000);
            System.out.println("Time " + name + ": " + LocalDateTime.now());
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
}