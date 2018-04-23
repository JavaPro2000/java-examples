package com.ofco.java.examples.concurrency;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class DemoThread implements Runnable {
    public static DemoThread newInstance(String name, List<String> outputList, CountDownLatch latch) {
        return newInstance(name, outputList, 500l, latch);
    }

    public static DemoThread newInstance(String name, List<String> outputList, long sleep, CountDownLatch latch) {
        return new DemoThread(name, outputList, sleep, latch);
    }

    public void run() {
        try {
            //String record = new String(ByteBuffer.allocate(102400).array());
            Thread.sleep(sleep);

            outputList.add(name + " - " + System.currentTimeMillis());
            latch.countDown();

            //record.length();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("Executing: " + name);
    }

    public String getName() {
        return this.name;
    }

    private DemoThread(String name, List<String> outputList, long sleep, CountDownLatch latch) {
        this.name = name;
        this.outputList = outputList;
        this.sleep = sleep;
        this.latch = latch;
    }

    final private String name;
    final List<String> outputList;
    final private long sleep;
    private final CountDownLatch latch;
}