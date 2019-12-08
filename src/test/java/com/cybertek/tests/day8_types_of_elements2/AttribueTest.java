package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.tests.day7_testng.RadioButtonTest;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttribueTest {

    @Test
    public void Test1(){
         WebDriver driver = WebDriverFactory.getDriver("chrome");
         driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement radioButton = driver.findElement(By.id("blue"));

        // get the value of name attribute
        System.out.println(radioButton.getAttribute("name"));
        //get the value of id attribute
        System.out.println(radioButton.getAttribute("id"));
        //get the value of type attribute
        System.out.println(radioButton.getAttribute("type"));
        //trying to get attribute doesnt exist
        //When we use non exist attrbute it will return NULL to us
        System.out.println(radioButton.getAttribute("href"));

        //attribute without value(ex. checked)
        //checked attribute value is boolean if it is checked it will be true
        System.out.println(radioButton.getAttribute("checked"));

        //"outer hTML" returns full html of that element
        System.out.println(radioButton.getAttribute("outerHTML"));



    }

}
