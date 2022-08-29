package com.solvd.taxi.externalTasks.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FixedThreadPoolDemo {

    public static void main(String[] args) {

        ThreadPoolExecutor ex = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            ThreadPool t = new ThreadPool("Task " + i);
            System.out.println("Task started: "+ t.getTaskName());

            ex.execute(t);
        }
        ex.shutdown();
    }
}