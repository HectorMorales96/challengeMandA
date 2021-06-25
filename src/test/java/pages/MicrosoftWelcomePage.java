package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MicrosoftWelcomePage extends BasePage {
    @FindBy(xpath = "//a[@class='c-uhf-nav-link' and text()='Office']")
    WebElement officeMenuButton;

    @FindBy(xpath = "//a[@class='c-uhf-nav-link' and text()='Windows']")
    WebElement windowsMenuButton;

    @FindBy(xpath = "//a[@class='c-uhf-nav-link' and text()='Surface']")
    WebElement surfaceMenuButton;

    @FindBy(xpath = "//a[@class='c-uhf-nav-link' and text()='Xbox']")
    WebElement xboxMenuButton;

    @FindBy(xpath = "//a[@class='c-uhf-nav-link' and text()='Deals']")
    WebElement dealsMenuButton;

    @FindBy(xpath = "//a[@class='c-uhf-nav-link' and text()='Support']")
    WebElement supportMenuButton;

    public MicrosoftWelcomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isOfficeMenuButtonDisplayed() {
        return isElementDisplayed(officeMenuButton);
    }

    public boolean isWindowsMenuButtonDisplayed() {
        return isElementDisplayed(windowsMenuButton);
    }

    public boolean isSurfaceMenuButtonDisplayed() {
        return isElementDisplayed(surfaceMenuButton);
    }

    public boolean isXboxMenuButtonDisplayed() {
        return isElementDisplayed(xboxMenuButton);
    }

    public boolean isDealsMenuButtonDisplayed() {
        return isElementDisplayed(dealsMenuButton);
    }

    public boolean isSupportMenuButtonDisplayed() {
        return isElementDisplayed(supportMenuButton);
    }

    public void clickOnWindowsMenu() {
        click(windowsMenuButton);
    }


}
