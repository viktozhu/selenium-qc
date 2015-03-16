package functional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by 1 on 16.03.2015.
 */
public class AbstractGridTest {
    protected ThreadLocal<WebDriver> threadDriver = null;

    @BeforeTest
    public void create()
    {
        //        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:9999/wd/hub"), DesiredCapabilities.firefox());
        threadDriver = new ThreadLocal<WebDriver>();
        WebDriver driver = new FirefoxDriver();
        threadDriver.set(driver);
    }

    @AfterTest
    public void close()
    {
        if (threadDriver.get() != null)
            threadDriver.get().quit();
    }
}
