package basePage;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import helper.WaitHelper;

public class BasePage {

    protected WebDriver driver;
    protected WaitHelper waitHelper;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }

    public boolean pageIsLoaded(WebElement... elements) {
        try {
            waitHelper.waitUntilAllElementsToBeVisible(elements);
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

}
