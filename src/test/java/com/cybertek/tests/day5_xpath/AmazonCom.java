package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonCom {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        WebElement searchText = driver.findElement(By.id("twotabsearchtextbox"));
        searchText.sendKeys("happy life");

        Thread.sleep(3000);
        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Go']"));
        searchButton.click();

        String resultText = String.valueOf(driver.findElement(By.xpath("//span[contains(text(),'results for')][1]")));
        System.out.println(resultText);
    }
}
