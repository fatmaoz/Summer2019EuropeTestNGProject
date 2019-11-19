package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @Test
    public void test1(){

        System.out.println("First Assertion");
        Assert.assertEquals(1,1);

        System.out.println("Second Assertion ");
        Assert.assertEquals("one","onE");

    }

    @Test
    public void test2(){
        //verify that title starts with C
        String actualTitle = "Cybertek";
        String expectedTitleBeginning = "C";

        System.out.println("first assertion");
        Assert.assertTrue(actualTitle.startsWith(expectedTitleBeginning),"verify title");

    }

     @Test
    public void test3(){
        Assert.assertNotEquals("one","two","it shouldnt be same");
     }

     @Test
    public void test4(){
        Assert.assertFalse(1<0 );
     }

}
