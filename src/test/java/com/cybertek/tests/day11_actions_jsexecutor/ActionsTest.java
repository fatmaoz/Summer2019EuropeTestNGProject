package com.cybertek.tests.day11_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {


    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
       // driver.quit();
    }

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/hovers");
        //Actions --> class that contains all the user interactions
        //how to create actions object/ passing driver as a constructor
        Actions actions = new Actions(driver);

        WebElement img = driver.findElement(By.tagName("img"));
        //perform() --> perform the action. complete the action
        //moveToElement() --> move your mouse to webelement(hover over)
        actions.moveToElement(img).perform();
        Assert.assertTrue(driver.findElement(By.linkText("View profile")).isDisplayed());

    }
    @Test
    public void DragAndDrop() {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        //how to create actions object/ passing driver as a constructor
        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        actions.pause(1000);
        //pause()--> waiting just like thread.sleep to this method, it will drag and drop
        driver.findElement(By.xpath("//button[.='Accept Cookies']")).click();
        //We have to provide source and target to this method, it will drag and drop
        actions.dragAndDrop(source,target).perform();

    }

    @Test
    public void DragAndDropChaining() {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        //how to create actions object/ passing driver as a constructor
        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        actions.pause(1000);
        //pause()--> waiting just like thread.sleep to this method, it will drag and drop
        driver.findElement(By.xpath("//button[.='Accept Cookies']")).click();
        //We have to provide source and target to this method, it will drag and drop

        //if you are chaining actions we add build() method before perform
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().build().perform();
    }

    @Test
    public void type(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");


        WebElement inputbox = driver.findElement(By.cssSelector("input[type='text']"));

    //    inputbox.sendKeys("fatma" );

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String str ="hello world";

        jse.executeScript("arguments[0].setAttribute('value', '" + str + "')",inputbox);
    }


    @Test
    public void Scroll() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            jse.executeScript("window.scrollBy(0,250)");
        }

        for (int i = 0; i < 5; i++) {
           Thread.sleep(500);
           //scrollUp
            jse.executeScript("window.scrollBy(0,-250)");
        }

    }

}
