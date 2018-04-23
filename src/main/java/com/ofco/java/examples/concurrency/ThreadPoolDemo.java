package com.ofco.java.examples.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int poolSize = Integer.parseInt(args[1]);

        List<String> outputList = (new ThreadPoolDemo()).serve(n, poolSize);

        System.out.println("size: " + outputList.size());
    }

    List<String> serve(int n, int poolSize) {
        System.out.println("ThreadPoolDemo Started");

        List<String> outputList = Collections.synchronizedList(new ArrayList<>());

        try {
            ExecutorService pool = Executors.newFixedThreadPool(poolSize);
            CountDownLatch latch = new CountDownLatch(n);

            for (int i = 0; i < n; i++) {
                pool.execute(DemoThread.newInstance("test -> " + i, outputList, 10 * 1000, latch));
                //System.out.println("Submitted Threads: " + i);
            }

            pool.shutdown();

            System.out.println("ThreadPoolDemo Waiting");

            while (!pool.isTerminated()) {
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("ThreadPoolDemo Completed");
        }

        return outputList;
    }
}