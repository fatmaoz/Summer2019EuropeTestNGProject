package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxDemo {

    @Test

    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkBox1 = driver.findElement(By.xpath("//input[@type=‘checkbox’][1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@type=‘checkbox’][2]"));

        System.out.println("checkBox1.Selected() = " + checkBox1);
        System.out.println("checkBox2.Selected() = " + checkBox2);
        //verify that checkbox1 is unselected and 2th is selected
        //isSelected()--> returns true if the element is selected
        //checkBox1.isSelected()-->it will return false since it should be unselected

        Assert.assertFalse(checkBox1.isSelected(),"Verify that check one is not selected");
        Assert.assertTrue(checkBox2.isSelected(),"Verify that check two is  selected");
        //select the first checkbox
        checkBox1.click();


    }
}
