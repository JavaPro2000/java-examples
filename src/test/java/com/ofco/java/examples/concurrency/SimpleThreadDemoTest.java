package com.ofco.java.examples.concurrency;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SimpleThreadDemoTest {

    @Test
    public void main() {
        int n = 100000;

        List<String> outputList = (new SimpleThreadDemo()).serve(n);

        System.out.println("size: " + outputList.size());

        Assert.assertTrue(n == outputList.size());
    }
}