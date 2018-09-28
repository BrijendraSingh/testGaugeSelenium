package util;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    public static WebDriver driver;


    @BeforeSuite
    public void setupDriver()
    {
        System.setProperty("webdriver.chrome.driver", "/Users/shivalis/Downloads/chromedriver");
        driver = new ChromeDriver();
    }


    @AfterSuite
    public void tearDown()
    {
        driver.quit();
    }

}
