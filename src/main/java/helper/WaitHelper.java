package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {

    private WebDriver driver;
    private WebDriverWait wait;
    private final int DEFAULT_TIME_OUT = 30;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(this.DEFAULT_TIME_OUT));
    }

    public WebElement waitForElementToBeClickable(WebElement webElement) {
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public WebElement waitUntilElementWillBeVisible(WebElement webelement) {
        return wait.until(ExpectedConditions.visibilityOf(webelement));
    }

    public void waitUntilAllElementsToBeVisible(WebElement... elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

}
