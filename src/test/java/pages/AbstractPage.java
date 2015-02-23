package pages;

import functional.AbstractTest;
import org.openqa.selenium.WebDriver;

import java.util.prefs.AbstractPreferences;

/**
 * Created by c246T on 23.02.2015.
 */
public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
