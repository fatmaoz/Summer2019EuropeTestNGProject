package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @Test
    public void test1(){

        System.out.println("First Assertion");
        Assert.assertEquals(1,1);

        System.out.println("Second Assertion ");
        Assert.assertEquals("one","one");

    }

    @Test
    public void test2(){

    }

}
