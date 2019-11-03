package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrlchanged {

    /**
     *Verify URL changed
     * open browser
     * go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
     * enter any email
     * click on Retrieve password
     *
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

       WebElement emailInput = driver.findElement(By.name("email"));

       emailInput.sendKeys("email@gmail.com");

        WebElement retrievePassword = driver.findElement(By.id("form_submit"));
        retrievePassword .click();

        String expectedUrl ="http://practice.cybertekschool.com/email_sent";

        String actualUrl = driver.getCurrentUrl();

        if(expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAİL");
            System.out.println("actualUrl = " + actualUrl);
            System.out.println("expectedUrl = " + expectedUrl);
        }
        driver.quit();

    }
}
