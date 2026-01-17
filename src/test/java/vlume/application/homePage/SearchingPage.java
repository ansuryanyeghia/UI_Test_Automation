package vlume.application.homePage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vlume.basePage.BasePage;

public class SearchingPage extends BasePage {

    @FindBy(xpath = "//div[@class='search-barr-gradient']//input[@class='search-input ng-untouched ng-pristine ng-valid'][1]")
    public WebElement searchInputField;

    @FindBy(xpath = "//mat-card[contains(@class, 'mat-card') and contains(@class, 'boxSize') and contains(@class, 'card-style')]/h1[@id='categoriesTitle']")
    public WebElement titleOfPage;

    @FindBy(xpath = "//div//p[@id='category5']")
    public WebElement historySectionFromCategoriesPage;

    @FindBy(xpath = "//div//h2[@id='Title1']")
    public WebElement titleOfPageAfterSearch;

    @FindBy(xpath = "//div[@id='stackContainer1']//a[@id='stackBook10']//div//h4[@id='bookTitle0']")
    public WebElement searchResultFromList;

    @FindBy(xpath = "//h1[@class='book-title title-web title-style ng-star-inserted']")
    public WebElement searchResult;


    public SearchingPage(WebDriver driver) {
        super(driver);
    }

    public void enterTextInSearchField(String text) {
        waitHelper.waitForElementToBeClickable(searchInputField);
        searchInputField.sendKeys(text + Keys.ENTER);
    }

    public String getPageTitle() {
        waitHelper.waitUntilElementWillBeVisible(titleOfPage);
        return titleOfPage.getText();
    }

    public String getPageTitleAfterSearch() {
        waitHelper.waitUntilElementWillBeVisible(titleOfPageAfterSearch);
        return titleOfPageAfterSearch.getText();
    }

    public String getTitleOfSearchResult() {
        waitHelper.waitUntilElementWillBeVisible(searchResultFromList);
        return searchResultFromList.getText();
    }

    public void pressOnTheSearchedResult(){
        waitHelper.waitForElementToBeClickable(searchResultFromList);
        searchResultFromList.click();
    }

    public String getTitleOfTheResultPage() {
        waitHelper.waitUntilElementWillBeVisible(searchResult);
        return searchResult.getText();
    }

    public boolean searchPageIsLoaded() {
        return super.pageIsLoaded(this.searchInputField, this.titleOfPage, this.historySectionFromCategoriesPage);
    }
}
