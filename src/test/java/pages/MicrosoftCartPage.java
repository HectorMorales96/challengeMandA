package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MicrosoftCartPage extends BasePage {
    int quantityValue;

    @FindAll(@FindBy(xpath = "//span[@itemprop='price']"))
    List<WebElement> pricesOnPage;

    @FindBy(xpath = "//div[@class='item-quantity']/select")
    WebElement quantityProductDropdown;

    public MicrosoftCartPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean validateThreePricesOnCart() {
        return (pricesOnPage.get(0).getText().equals(pricesOnPage.get(1).getText()) &&
                pricesOnPage.get(0).getText().equals(pricesOnPage.get(2).getText()));
    }

    public void selectQuantityOnDropdown(String quantity) throws InterruptedException {
        quantityValue = Integer.parseInt(quantity);
        Select quantityDropdown = new Select(quantityProductDropdown);
        quantityDropdown.selectByValue(quantity);
        Thread.sleep(1000);
    }

    public boolean validatePriceOnCart() {
        float totalPrice = Float.parseFloat(pricesOnPage.get(0).getText().replace("$", "").replace(",", "")) * quantityValue;
        float getTotalPrice = Float.parseFloat(pricesOnPage.get(2).getText().replace("$", "").replace(",", ""));
        System.out.println(totalPrice);
        System.out.println(getTotalPrice);
        return totalPrice == getTotalPrice;
    }


}
