package functional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by c246T on 23.02.2015.
 */
public class AbstractTest {
    public WebDriver driver;

    @BeforeSuite
    public void initEnv()
    {
        driver = new FirefoxDriver();
    }

    @AfterSuite
    public void shutEnv()
    {
        if (driver != null)
            driver.quit();
    }
}
