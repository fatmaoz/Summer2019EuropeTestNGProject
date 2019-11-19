package com.cybertek.tests.day7_testng;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElementTest {



    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenRadioButton = driver.findElement(By.id("green"));

        //How can we check is enabled or not?
        System.out.println("Is element enabled: " + greenRadioButton.isEnabled());

        //verify that
        Assert.assertFalse(greenRadioButton.isEnabled(),"verify that green button is not enbled");

        greenRadioButton.click();



    }

    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dynamic_controls");


        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
        System.out.println("is input enabled: " + inputBox.isEnabled());
        Thread.sleep(3000);
        inputBox.sendKeys("Mike Smith");
    }
}
