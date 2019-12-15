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

public class HW3TC6 {


    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
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

        Thread.sleep(5000);
        String testers = "Testers Meeting";

       //I couldnt take date
        List<WebElement> expectedResult = driver.findElements(By.xpath("(//table/tbody/tr/td[contains(text(),'Testers Meeting')])[1]/../td"));

        WebElement testersLink = driver.findElement(By.xpath("(//td[text()='Testers Meeting'])[1]"));
        Thread.sleep(1000);
        testersLink.click();

        Thread.sleep(3000);
        List<WebElement> actualResult = driver.findElements(By.xpath("(//div[@class = 'control-label'])"));
        for (int i = 0; i <8 ; i++) {
            System.out.println(actualResult.get(i).getText());

            System.out.println("-----------");
            System.out.println(expectedResult.get(i).getText());
      //  Assert.assertEquals(actualResult.get(i).getText(),expectedResult.get(i).getText());
        }




    }

    private int getNumberOfColumns() {
        List<WebElement> allColumns = driver.findElements(By.xpath("//table/thead/tr[@class='grid-header-row']"));
        return allColumns.size();
    }
}
