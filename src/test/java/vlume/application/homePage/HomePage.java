package vlume.application.homePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vlume.basePage.BasePage;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[contains(@href,'STK_SITE_RECENT')]/preceding-sibling::*[normalize-space()='Recently Added']")
    public WebElement recentlyAddedPart;

    @FindBy(id = "SeeMore0")
    public WebElement seeMoreForRecentlyAddedPart;

    @FindBy(xpath = "//a[contains(@href,'STK_SITE_CHILD_ILLUSTRATED')]/preceding-sibling::*[normalize-space()='Illustrated Books']")
    public WebElement illustratedBooksPart;

    @FindBy(id = "SeeMore1")
    public WebElement seeMoreForIllustratedBooksPart;

    @FindBy(id = "searchButton")
    public WebElement searchButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void pressOnTheSeeMoreForRecentlyAddedPart() {
        waitHelper.waitForElementToBeClickable(seeMoreForRecentlyAddedPart);
        seeMoreForRecentlyAddedPart.click();
    }

    public void pressOnTheSearchButton() {
        waitHelper.waitForElementToBeClickable(searchButton);
        searchButton.click();
    }

    public boolean homePageIsLoaded() {
        return super.pageIsLoaded(this.recentlyAddedPart, this.seeMoreForRecentlyAddedPart,
                this.illustratedBooksPart, this.seeMoreForIllustratedBooksPart, this.searchButton);
    }


}
