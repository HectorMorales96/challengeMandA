package tests;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ReadJson;

public class MicrosoftTest extends BaseTest {
    MicrosoftWelcomePage microsoftWelcomePage;
    WindowsPage windowsPage;
    MicrosoftSearchResultsPage microsoftSearchResultsPage;
    MicrosoftProductPage microsoftProductPage;
    MicrosoftCartPage microsoftCartPage;
    ReadJson readJson = new ReadJson();

    @Test(priority = 0, description = "First Test Case")
    public void firstTestCase(Method method) throws InterruptedException {
        microsoftWelcomePage = new MicrosoftWelcomePage(getDriver());
        //ExtentReports Description
        startTest(method.getName(), "Microsoft Scenario");
        //System.out.println(readJson.getDataFromJson(System.getProperty("user.dir") + "/src/test/java/tests/data/data.json"));

        Assert.assertTrue(microsoftWelcomePage.isOfficeMenuButtonDisplayed() &&
                microsoftWelcomePage.isWindowsMenuButtonDisplayed() &&
                microsoftWelcomePage.isSurfaceMenuButtonDisplayed() &&
                microsoftWelcomePage.isXboxMenuButtonDisplayed() &&
                microsoftWelcomePage.isDealsMenuButtonDisplayed() &&
                microsoftWelcomePage.isSupportMenuButtonDisplayed(), "Menu item(s) is not being displayed");

        microsoftWelcomePage.clickOnWindowsMenu();

        windowsPage = new WindowsPage(getDriver());
        windowsPage.clickOnWindows10MenuButton();
        windowsPage.printAllWindows10MenuButtonDropdownOptions();
        windowsPage.clickOnSearchAndSearchFor("Visual Studio");

        microsoftSearchResultsPage = new MicrosoftSearchResultsPage(getDriver());
        String firstPrice = microsoftSearchResultsPage.printFirstThreePricesOnSearchResultAndGetOneByIndex(0);
        microsoftSearchResultsPage.clickOnSearchResultByIndex(0);

        microsoftProductPage = new MicrosoftProductPage(getDriver());
        Assert.assertEquals(microsoftProductPage.getProductPrice(), firstPrice);
        microsoftProductPage.clickAddToCart();

        microsoftCartPage = new MicrosoftCartPage(getDriver());
        Assert.assertTrue(microsoftCartPage.validateThreePricesOnCart());

        microsoftCartPage.selectQuantityOnDropdown("20");
        Assert.assertTrue(microsoftCartPage.validatePriceOnCart());

    }
}