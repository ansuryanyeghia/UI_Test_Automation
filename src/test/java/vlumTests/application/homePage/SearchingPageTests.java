package vlumTests.application.homePage;

import application.homePage.HomePage;
import application.homePage.SearchingPage;
import application.signInPage.SignInPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import provider.UrlProvider;
import vlumTests.baseTest.BaseTest;

import java.io.IOException;

public class SearchingPageTests extends BaseTest {
    SignInPage signInPage;
    HomePage homePage;
    SearchingPage searchingPage;
    SoftAssert softAssert;

    @BeforeClass
    public void goToUrl() {
        driver.get(UrlProvider.getSignInPageUrl());
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
        searchingPage = new SearchingPage(driver);
        softAssert = new SoftAssert();
    }

    @Test(priority = 1)
    public void singInAndGoToSearchPage() throws IOException {
        softAssert.assertTrue(signInPage.signInPageIsLoaded(), "Sign in page is not loaded");
        signInPage.signIn();
        homePage.homePageIsLoaded();
        softAssert.assertEquals(driver.getCurrentUrl(), UrlProvider.getWelcomePageUrl());
        softAssert.assertTrue(homePage.homePageIsLoaded(), "Home page is not loaded");
        homePage.pressOnTheSearchButton();
        searchingPage.searchPageIsLoaded();
        softAssert.assertEquals(driver.getCurrentUrl(), UrlProvider.getSearchPageUrl());
        softAssert.assertTrue(searchingPage.searchPageIsLoaded(), "Search page is not loaded");
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void verifySearchPageElements() throws InterruptedException {
        softAssert.assertTrue(searchingPage.searchPageIsLoaded(), "Search page is not loaded");
        String pageTitle = searchingPage.getPageTitle();
        softAssert.assertEquals(pageTitle, "Categories", "Page title is not as expected");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void verifySearchFunctionality() throws InterruptedException {

        searchingPage.enterTextInSearchField("ՀՈԼ");
        waitHelper.waitUntilElementWillBeVisible(searchingPage.titleOfPageAfterSearch);
        String pageTitleAfterSearch = searchingPage.getPageTitleAfterSearch();
        softAssert.assertEquals(pageTitleAfterSearch, "Top results", "Page title after search isn't as expected");
        String searchResult = searchingPage.getTitleOfSearchResult();
        softAssert.assertEquals(searchResult, "ՀՈԼ");
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void verifyPressOnTheSearchedResult() throws InterruptedException {
        waitHelper.waitUntilElementWillBeVisible(searchingPage.titleOfPageAfterSearch);
        String pageTitleAfterSearch = searchingPage.getPageTitleAfterSearch();
        softAssert.assertEquals(pageTitleAfterSearch, "Top results", "Page title after search isn't as expected");
        String searchResult = searchingPage.getTitleOfSearchResult();
        softAssert.assertEquals(searchResult, "ՀՈԼ");
        searchingPage.pressOnTheSearchedResult();
        Thread.sleep(5000);
        softAssert.assertEquals(driver.getCurrentUrl(), UrlProvider.getBookPageUrl());
        String titleOfTheResultPage = searchingPage.getTitleOfTheResultPage();
        softAssert.assertEquals(titleOfTheResultPage, "Հոլ");
        softAssert.assertAll();
    }
}

