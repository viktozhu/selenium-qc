package functional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.PropertyLoader;
import webdriver.Browser;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by c246T on 23.02.2015.
 */
public class AbstractTest {
    public Browser browser;

    @BeforeSuite
    public void initEnv()
    {
        if (PropertyLoader.loadProperty("browser").equals("firefox"))
            browser = new Browser(new FirefoxDriver());
        else if (PropertyLoader.loadProperty("browser").equals("chrome")) {
            File file = new File("D:\\Selenium\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
            browser = new Browser(new ChromeDriver());
        }
        else
            browser = new Browser(new HtmlUnitDriver());

        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void shutEnv()
    {
        if (browser != null)
            browser.quit();
    }
}
