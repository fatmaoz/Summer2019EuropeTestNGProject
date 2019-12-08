package com.cybertek.tests.Homeworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HW2TC6 {

    @Test
    public void signUpMail(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.tempmailaddress.com/");



    }

}
