package functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ChildDressPage;
import pages.ChildPage;
import pages.HomePage;

import java.util.List;

/**
 * Created by c246T on 23.02.2015.
 */
public class FilteringTest extends AbstractTest{

    @Test
    public void visualFilterTest()
    {
        openDetskiyMir();
        openDetskayaOdezhda();
    }

    @Test
    public void priceFilterTest()
    {
        openDetskiyMir();
        openDetskayaOdezhda();
        sortByNew();
    }

    public void stateFilterTest ()
    {

    }

    public void sortByNew()
    {
        ChildDressPage childDressPage = new ChildDressPage(driver);
        Assert.assertTrue(childDressPage.sortByNew(), "Sorted by new ");
    }

    public void openDetskiyMir()
    {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.openDetskiyMir();
        ChildPage childPage = new ChildPage(driver);
        Assert.assertTrue(childPage.isOpened());
    }

    public void openDetskayaOdezhda()
    {
        ChildPage childPage = new ChildPage(driver);
        childPage.openOdezhda();
        ChildDressPage childDressPage = new ChildDressPage(driver);
        Assert.assertTrue(childDressPage.isOpened());
    }



}
