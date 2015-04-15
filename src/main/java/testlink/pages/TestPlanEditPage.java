package testlink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testlink.models.TestPlan;

/**
 * Created by admin on 08.04.2015.
 */
public class TestPlanEditPage extends AbstractPage {
    private static final By nameField = By.name("testplan_name");
    private static final By descriptionField = By.xpath("/html/body");
    private static final By activeCheckBox = By.name("active");
    private static final By isPublicCheckBox = By.name("is_public");
    private static final By createButton = By.name("do_create");
    private static final By testPlanExists = By.xpath("//p[contains(text(),'There is already a Test Plan with this name. Please choose another name!')]");
    private static final By cancelBtn = By.name("go_back");

    public TestPlanEditPage(WebDriver driver) {
        super(driver);
    }

    public void createTestPlan(TestPlan testPlan) {
        driver.findElement(nameField).sendKeys(testPlan.name);
        switchToIFrame();
        driver.findElement(descriptionField).sendKeys(testPlan.description);
        switchToMainFrame();

        if (testPlan.active)
            driver.findElement(activeCheckBox).click();
        if (testPlan.pub)
            driver.findElement(isPublicCheckBox).click();
        driver.findElement(createButton).click();
        if (driver.findElements(testPlanExists).size()>0)
            driver.findElement(cancelBtn).click();
    }
}
