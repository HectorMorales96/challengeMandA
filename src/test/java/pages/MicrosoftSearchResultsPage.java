package pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.logs.Log;

import java.util.List;

public class MicrosoftSearchResultsPage extends BasePage {

    @FindAll(@FindBy(xpath = "//span[@itemprop='price']"))
    List<WebElement> searchResultPrices;

    @FindAll(@FindBy(xpath = "//li[@aria-label='item']"))
    List<WebElement> searchedItems;

    @FindBy(xpath = "//button[@id='R1MarketRedirect-close']")
    WebElement stayInCurrentLanguage;

    public MicrosoftSearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String printFirstThreePricesOnSearchResultAndGetOneByIndex(int index) {
        Log.info("Printing Prices:");
        for (int i = 0; i < 3; i++) {
            System.out.println(searchResultPrices.get(i).getText());
        }
        return searchResultPrices.get(index).getText();
    }

    public void clickOnSearchResultByIndex(int index) {
        try {
            searchedItems.get(index).click();
        } catch (ElementClickInterceptedException e) {
            stayInCurrentLanguage.click();
            searchedItems.get(index).click();
        }
    }
}
