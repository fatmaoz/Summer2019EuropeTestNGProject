package com.cybertek.tests.Homeworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HW3TC4 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        // driver.quit();
    }

    @Test
    public void verifyPageNumbers() throws InterruptedException {

        driver.get("https://qa1.vytrack.com/");
        WebDriverWait wait = new WebDriverWait(driver, 20);
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
        Thread.sleep(4000);
        String completeSentence = driver.findElement(By.xpath("//div[@class='pagination pagination-centered']")).getText();
        System.out.println(completeSentence);
        String [] array =completeSentence.split(" ");

        int rowNumber = getNumberOfRows();
       System.out.println(array[5]);
       int numbersOfResult = Integer.parseInt(array[5]);

        Assert.assertEquals(rowNumber,numbersOfResult);


    }
    private int getNumberOfRows() {
        List<WebElement> allRows = driver.findElements(By.xpath("//tbody/tr"));
        return allRows.size();
    }
}
