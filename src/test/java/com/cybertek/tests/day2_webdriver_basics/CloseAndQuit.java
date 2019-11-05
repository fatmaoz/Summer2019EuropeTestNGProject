package com.cybertek.tests.day2_webdriver_basics;

import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.util.ISO8601Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit
{
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        Thread.sleep(3000);


    }
}
