package testlink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testlink.models.TestSuite;

/**
 * Created by 1 on 20.03.2015.
 */
public class SpecificationPage extends AbstractPage{

    private static final By specPage = By.xpath("//a[@accesskey='t']");
    private static final By actionsBtn = By.xpath("//img[@title='Actions']");
    private static final By createSuiteBtn = By.id("new_testsuite");
    private static final By suiteName = By.id("name");
    private static final By detailsFrame = By.xpath("//iframe[@title='Rich text editor, details']");
    private static final By frameBody = By.tagName("body");
    private static final By saveSuiteButton = By.name("add_testsuite_button");


    public SpecificationPage(WebDriver driver){
        super(driver);
    }

    public void open(){
        switchToTitleBar();
        driver.findElement(specPage).click();
    }

    public void createSuite(TestSuite suite){
        switchToWorkFrame();
        driver.findElement(actionsBtn).click();
        driver.findElement(createSuiteBtn).click();
        driver.findElement(suiteName).sendKeys(suite.name);
        driver.switchTo().frame(driver.findElement(detailsFrame));
        driver.findElement(frameBody).sendKeys(suite.details);
        driver.findElement(saveSuiteButton).click();
    }
}
