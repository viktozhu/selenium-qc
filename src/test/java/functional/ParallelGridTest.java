package functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by c246T on 11.03.2015.
 */
public class ParallelGridTest extends AbstractGridTest{


    @Test
    public void secondThreadTest() throws MalformedURLException {

        threadDriver.get().get("http://rozetka.com.ua/");
        threadDriver.get().findElement(By.className("header-search-input-text"));
        threadDriver.get().quit();
    }


}
