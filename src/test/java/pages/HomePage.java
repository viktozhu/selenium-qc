package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by c246T on 18.02.2015.
 */
public class HomePage extends AbstractPage{

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public void open()
    {
        driver.get("http://olx.ua/uk/");
    }

    public void openDetskiyMir()
    {
        driver.findElement(By.cssSelector("a[data-code='detskiy-mir']")).click();
    }

}
