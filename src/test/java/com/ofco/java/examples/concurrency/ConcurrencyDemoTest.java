package com.ofco.java.examples.concurrency;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ConcurrencyDemoTest {
    @Test
    public void threadPoolDemo() {
        int n = 100000;
        int poolSize = 10000;

        List<String> outputList = (new ThreadPoolDemo()).serve(n, poolSize);

        System.out.println("size: " + outputList.size());

        Assert.assertTrue(n == outputList.size());
    }

    @Test
    public void simpleThreadDemo() {
        int n = 100000;

        List<String> outputList = (new SimpleThreadDemo()).serve(n);

        System.out.println("size: " + outputList.size());

        Assert.assertTrue(n == outputList.size());
    }
}