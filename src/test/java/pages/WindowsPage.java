package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.logs.Log;

import java.util.List;

public class WindowsPage extends BasePage {
    @FindBy(xpath = "//button[text()='Windows 10']")
    WebElement windows10MenuButton;

    @FindAll(@FindBy(xpath = "//button[text()='Windows 10']/following-sibling::ul/li"))
    List<WebElement> windows10MenuButtonDropdownOptions;

    @FindBy(xpath = "//button[@id='search']")
    WebElement searchButton;

    @FindBy(xpath = "//input[@id='cli_shellHeaderSearchInput']")
    WebElement searchInput;

    public WindowsPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnWindows10MenuButton() {
        windows10MenuButton.click();
    }

    public void printAllWindows10MenuButtonDropdownOptions() {
        Log.info("Printing Windows 10 dropdown option:");
        for(WebElement we:windows10MenuButtonDropdownOptions) {
            System.out.println(we.getText());
        }
    }

    public void clickOnSearchAndSearchFor(String search) {
        searchButton.click();
        searchInput.sendKeys(search);
        searchButton.click();
    }

}
