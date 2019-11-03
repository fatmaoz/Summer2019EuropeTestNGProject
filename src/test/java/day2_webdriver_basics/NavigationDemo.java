package day2_webdriver_basics;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {
        //setting up the browser
        WebDriverManager.chromedriver().setup();
        //import class CMD+ENTER or ALT+enter or CONTROL +SPACE
        //selenium object
        WebDriver driver = new ChromeDriver();
        //navigate to website
        driver.get("https://www.amazon.com");

        //another way of opening website
        driver.navigate().to("https://www.facebook.com");

        //goes back to previous webpage
        driver.navigate().back();

        Thread.sleep(3000);

        //goes forward after goes back
        driver.navigate().forward();

        //refresh the page
        driver.navigate().refresh();
    }

}
