package functional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;

/**
 * Created by c246T on 23.02.2015.
 */
public class AbstractTest {
    public WebDriver driver;

    @BeforeSuite
    public void initEnv()
    {
        File file = new File("d:\\Selenium\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void shutEnv()
    {
        if (driver != null)
            driver.quit();
    }
}
