package com.ofco.java.examples.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class SimpleThreadDemo {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        List<String> outputList = (new SimpleThreadDemo()).serve(n);

        System.out.println("size: " + outputList.size());
    }

    List<String> serve(int n) {
        System.out.println("SimpleThreadDemo Started");

        List<String> outputList = Collections.synchronizedList(new ArrayList<>());

        try {
            CountDownLatch latch = new CountDownLatch(n);

            for (int i = 0; i < n; i++) {
                (new Thread(DemoThread.newInstance("test -> " + i, outputList, 10 * 1000, latch))).start();
                //System.out.println("Submitted Threads: " + i);
            }

            System.out.println("SimpleThreadDemo Waiting");

            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("SimpleThreadDemo Completed");
        }

        return outputList;
    }
}