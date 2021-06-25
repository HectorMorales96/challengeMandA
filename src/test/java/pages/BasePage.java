package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //Click
    public void click(WebElement we) {
        we.click();
    }
    //Write Text
    public void writeText(WebElement we, String text) {
        we.sendKeys(text);
    }

    //Get Text
    public String readText(WebElement we) {
        return we.getText();
    }

    public boolean isElementDisplayed(WebElement we) {
        return we.isDisplayed();
    }

    public WebElement waitVisibility(WebElement we) {
        return wait.until(ExpectedConditions.visibilityOf(we));
    }

}
