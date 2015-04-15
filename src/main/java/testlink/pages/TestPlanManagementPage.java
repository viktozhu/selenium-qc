package testlink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testlink.models.TestPlan;

/**
 * Created by admin on 08.04.2015.
 */
public class TestPlanManagementPage extends AbstractPage {

    private static final By createBtn = By.name("create_testplan");
    private static final By yesPopupBtn = By.id("ext-gen20");

    public TestPlanManagementPage(WebDriver driver) {
        super(driver);
    }

    public TestPlanEditPage createTestPlan(){
        driver.findElement(createBtn).click();
        return new TestPlanEditPage(driver);
    }

    public boolean isTestPlanPresent(TestPlan testPlan){
        return driver.findElements(By.linkText(testPlan.name)).size() >0;
    }

    public void deleteTestPlan(TestPlan testPlan){
        driver.findElement(By.xpath("//a[contains(text(),'"+testPlan.name+"')]/ancestor::tr/td/img[@alt='Delete the test plan?']")).click();
        driver.findElement(yesPopupBtn).click();
    }


}
