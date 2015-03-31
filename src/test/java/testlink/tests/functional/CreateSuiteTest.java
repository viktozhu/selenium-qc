package testlink.tests.functional;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import testlink.steps.TestSteps;

/**
 * Created by 1 on 20.03.2015.
 */
public class CreateSuiteTest extends TestSteps {

    @BeforeSuite
    public void initEnv()
    {
        driver = new FirefoxDriver();
    }

    @Test
    public void createSuite(){
        Assert.assertTrue(login("admin","admin"), "Login failed");
        Assert.assertTrue(createTestSuite(), "Suite creation failed");
    }

    @AfterSuite
    public void shutEnv(){
        if (driver != null)
            driver.quit();
    }
}
