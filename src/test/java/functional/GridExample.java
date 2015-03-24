package functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by c246T on 11.03.2015.
 */
public class GridExample extends AbstractGridTest{

    @Test
    public void gridTest() throws MalformedURLException {
        threadDriver.get().get("http://olx.ua/uk/");
        threadDriver.get().findElement(By.id("message_system"));
        threadDriver.get().quit();
    }


}
