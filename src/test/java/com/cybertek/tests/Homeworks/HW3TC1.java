package com.cybertek.tests.Homeworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW3TC1 {

    @BeforeMethod
    public void SetUpMethod() throws InterruptedException {
       WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Thread.sleep(1000);

    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
      // driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa1.vytrack.com/");
        WebElement userName = driver.findElement(By.xpath("//*[@id='prependedInput']"));
        userName.sendKeys("storemanager85");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        WebElement logInButton = driver.findElement(By.cssSelector("button.btn.btn-uppercase"));
        logInButton.click();
        Thread.sleep(4000);
        Actions actions = new Actions(driver);
        WebElement activities = driver.findElement(By.xpath("(//span[contains(text(),'Activities')])[1]"));
        WebElement calenderEvents = driver.findElement(By.xpath("//span[text()='Calendar Events']"));
        actions.moveToElement(activities).clickAndHold().moveToElement(calenderEvents).click(calenderEvents).build().perform();
        Thread.sleep(3000);
        WebElement optionsLink = driver.findElement(By.xpath("(//div[@data-toggle='dropdown'])[2]"));
        Assert.assertTrue(optionsLink.isDisplayed(),"Verify that optionsLin is Displayed");


    }

}
