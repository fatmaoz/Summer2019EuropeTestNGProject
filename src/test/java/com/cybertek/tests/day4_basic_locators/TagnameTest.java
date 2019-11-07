package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagnameTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInput = driver.findElement(By.tagName("input"));

        fullNameInput.sendKeys("Mike Smith with TagName");

        WebElement emialInput = driver.findElement(By.name("email"));
        emialInput.sendKeys("fatmas@gmail.com");

        WebElement signUpButton= driver.findElement(By.tagName("button"));
        signUpButton.click();
        String resultMessage=driver.findElement(By.tagName("signup_message")).getText();

        WebElement resMessage = driver.findElement(By.tagName("h3"));
        String result = resMessage.getText();
        System.out.println(result);

    }


}
