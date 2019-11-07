package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocaterTest {

    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullnameInput = driver.findElement(By.name("full_name"));
        fullnameInput.sendKeys("Mike Smith");


        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("fatmas@gmail.com");

        WebElement retrievebutton = driver.findElement(By.name("wooden_spoon"));
        retrievebutton.click();
        //verify that you got Thank you for signing up. Click the button below to return to the home page.

        String gotMessage = "Thank you for signing up. Click the button below to return to the home page.";
        String actualMessage=driver.findElement(By.name("signup_message")).getText();
        if(gotMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("expectedMessage = " + gotMessage);
            System.out.println("actualMessage = " + actualMessage);
        }
        }
    }

