package com.cybertek.tests.Homeworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HW3TC3 {

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
        WebDriverWait wait =new WebDriverWait(driver,20);
        WebElement userName = driver.findElement(By.xpath("//*[@id='prependedInput']"));
        userName.sendKeys("storemanager57");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        WebElement logInButton = driver.findElement(By.cssSelector("button.btn.btn-uppercase"));
        logInButton.click();
        Thread.sleep(4000);


        Actions actions = new Actions(driver);

        WebElement activities = driver.findElement(By.xpath("(//span[contains(text(),'Activities')])[1]"));
        WebElement calenderEvents = driver.findElement(By.xpath("//span[text()='Calendar Events']"));
        actions.moveToElement(activities).clickAndHold().moveToElement(calenderEvents).click(calenderEvents).build().perform();

        WebElement actualResult = driver.findElement(By.xpath("//button[contains(text(),'25')]"));

        Assert.assertEquals(actualResult.getText(),"25");

    }

    @Test
    public void TC3() throws InterruptedException {
        driver.get("https://qa1.vytrack.com/");
        WebDriverWait wait =new WebDriverWait(driver,20);
        WebElement userName = driver.findElement(By.xpath("//*[@id='prependedInput']"));
        userName.sendKeys("storemanager57");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        WebElement logInButton = driver.findElement(By.cssSelector("button.btn.btn-uppercase"));
        logInButton.click();
        Thread.sleep(4000);



        WebElement Actv = driver.findElement(By.xpath("(//span[@class = 'title title-level-1'])[5]"));
        WebElement cEvents = driver.findElement(By.xpath("(//span[@class = 'title title-level-2'])[14]"));
        WebDriverWait waits = new WebDriverWait(driver, 20);
        waits.until(ExpectedConditions.elementToBeClickable(Actv));
        Actions actions = new Actions(driver);
        actions.moveToElement(Actv).clickAndHold().moveToElement(cEvents).click().build().perform();
        Thread.sleep(5000);
        //Drop-Down listesindeki elementlere click yapilamiyor
        WebElement dropDownElement = driver.findElement(By.xpath("//button[@* = 'btn dropdown-toggle ']"));
        dropDownElement.click();
        Thread.sleep(5000);

        WebElement number = driver.findElement(By.xpath("//a[contains(text(),'50')]"));
        number.click();
//            System.out.println( ItemsInList.getText());

//        //print any specific element by using index
//        System.out.println(listofLinks.get(0).getText());
//
//        //click specific element in the dropdown list
//        //listofLinks.get(3).click();
//        //or
//        driver.findElement(By.xpath("50")).click();
//
//        Thread.sleep(2000);
//        String viewPerPage = dropDownElement.getText();
//
//        System.out.println("viewPerPage = " + viewPerPage);
//
//        Assert.assertEquals(viewPerPage, "25", "Verify that view per page equals 25");
    }


}
