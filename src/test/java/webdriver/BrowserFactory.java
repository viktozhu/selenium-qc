package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import utils.PropertyLoader;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by c246T on 04.03.2015.
 */
public class BrowserFactory {

    /* Browsers constants */
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String HTML_UNIT = "htmlunit";

    /* Platform constants */
    public static final String WINDOWS = "windows";
    public static final String MAC = "mac";

    public static Browser create(String browser)
    {
        Browser testDriver = setDefaultConfiguration(browser);
        return testDriver;
    }

    private static Browser setDefaultConfiguration(String browser)
    {
        WebDriver driver = null;
        DesiredCapabilities capabilities = setDefaultCapabilities(browser);

        if (browser.equals(FIREFOX))
        {
            driver = new FirefoxDriver(capabilities);
        } else
        if (browser.equals(CHROME))
        {
            //system.property (env variable) = "webdriver.chrome.driver"
            System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
            driver = new ChromeDriver(capabilities);
        } else
        if (browser.equals(HTML_UNIT))
        {
            driver = new HtmlUnitDriver(capabilities);
        } else
            Assert.fail("Browser configuration error");

        //additional configuration
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return new Browser(driver);
    }

    private static WebDriver setScreenReolution(WebDriver driver)
    {
        int xDimension = Integer.parseInt(PropertyLoader.loadProperty("selenium.screen.x"));
        int yDimension = Integer.parseInt(PropertyLoader.loadProperty("selenium.screen.y"));
        driver.manage().window().setSize(new Dimension(xDimension,yDimension));
        return driver;
    }

    private static DesiredCapabilities setDefaultCapabilities(String browser)
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities = setPlatform(capabilities,"");

        if (browser.contains(FIREFOX)){
            capabilities = DesiredCapabilities.firefox();
        } else
        if (browser.contains(CHROME)){
            capabilities = DesiredCapabilities.chrome();
        } else
        if (browser.contains(HTML_UNIT)){
            capabilities = DesiredCapabilities.htmlUnit();
        }else
            Assert.fail("No configuration available for driver");

        return capabilities;
    }

    private static DesiredCapabilities setPlatform(DesiredCapabilities capabilities,String platformName)
    {
        if (platformName.equals(MAC))
        {
            capabilities.setPlatform(Platform.MAC);
        } else
        {
            capabilities.setPlatform(Platform.WINDOWS);
        }
        return capabilities;
    }
}
