package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyConfirmationMessage {
    public static void main(String[] args) throws InterruptedException {


    /**
     * Verify confirmation message
     * open browser
     * go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
     * enter any email
     * verify that email is displayed in the input box
     * click on Retrieve password
     * verify that confirmation message says 'Your e-mail's been sent!'
     *
     *
     */


    WebDriver driver = WebDriverFactory.getDriver("chrome");

    driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement emailInputbox = driver.findElement(By.name("email"));

        String expectedEmail = "test@gmail.com";

        emailInputbox.sendKeys((expectedEmail));


        String actualResult = emailInputbox.getAttribute("value");
        if(expectedEmail.equals(actualResult)){
            System.out.println("PASS");

        }
        else{
            System.out.println("FAIL");
            System.out.println("expectedEmail = " + expectedEmail);
            System.out.println("actualResult = " + actualResult);

        }


        WebElement retrrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrrievePasswordButton.click();


        String expectedMessage = "Your e-mail's been sent!,";

        WebElement messageElement = driver.findElement(By.name("confirmation_message"));

        String actualMessage = messageElement.getText();

        if(expectedMessage.equals(actualMessage)){
            System.out.println("PASS");

        }else{
            System.out.println("FAIL");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);

        }
        Thread.sleep(3000);
        driver.quit();
    }
}
