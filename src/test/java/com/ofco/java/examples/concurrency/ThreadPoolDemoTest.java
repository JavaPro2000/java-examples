package com.ofco.java.examples.concurrency;

import com.ofco.java.examples.concurrency.ThreadPoolDemo;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ThreadPoolDemoTest {
    @Test
    public void main() {
        int n = 100000;
        int poolSize = 10000;

        List<String> outputList = (new ThreadPoolDemo()).serve(n, poolSize);

        System.out.println("size: " + outputList.size());

        Assert.assertTrue(n == outputList.size());
    }
}