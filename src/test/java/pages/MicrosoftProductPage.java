package pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MicrosoftProductPage extends BasePage {
    @FindBy(xpath = "//div[contains(@id, 'ProductPrice')]")
    WebElement productPrice;

    @FindBy(xpath = "//button[@aria-label='Add to cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "//div[@aria-label='Close']")
    WebElement closeXOnSignMeUpPopUp;

    public MicrosoftProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public void clickAddToCart() {
        try {
            addToCartButton.click();
        } catch (ElementClickInterceptedException e) {
            closeXOnSignMeUpPopUp.click();
            addToCartButton.click();
        }
    }
}
