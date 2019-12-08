package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {


    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/upload");

        String projectPath = System.getProperty("user.dir");
        String relativePath = "src/test/resources/testfile.txt";

        String filePath = projectPath + "/" + relativePath;
        System.out.println(filePath);
        //file path unique for each computer
        driver.findElement(By.name("file")).sendKeys(filePath);
        //checking upload button
        driver.findElement(By.id("file-submit")).click();
        //getting text of webelement
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        //verify that file name is displayed in the next page
        Assert.assertEquals(actualFileName,"testfile.txt","Verify the file name");
    }
}
