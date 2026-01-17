package vlumTests.application.homePage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlumTests.baseTest.BaseTest;
import vlume.application.homePage.HomePage;
import vlume.application.homePage.SearchingPage;
import vlume.application.signIn.SignInPage;
import vlume.provider.urlPrividers.homeUrl.HomePageUrl;
import vlume.provider.urlPrividers.welcomeUrl.WelcomeUrl;

public class SearchingPageTests extends BaseTest {
    SignInPage signInPage;
    HomePage homePage;
    SearchingPage searchingPage;
    SoftAssert softAssert;

    @BeforeClass
    public void goToUrl() {
        driver.get(WelcomeUrl.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
        searchingPage = new SearchingPage(driver);
        softAssert = new SoftAssert();
    }

    @Test(priority = 1)
    public void singInAndGoToSearchPage() throws InterruptedException {
        softAssert.assertTrue(signInPage.signInPageIsLoaded(), "Sign in page is not loaded");
        Thread.sleep(5000);
        signInPage.enterEmail("gyumrisymphony@gmail.com");
        signInPage.enterPassword("arm30Mozart");
        signInPage.pressSignInButton();
        Thread.sleep(5000);
        softAssert.assertEquals(driver.getCurrentUrl(), WelcomeUrl.WELCOME_PAGE_URL.getUrl());
        softAssert.assertTrue(homePage.homePageIsLoaded(), "Home page is not loaded");
        homePage.pressOnTheSearchButton();
        Thread.sleep(5000);
        softAssert.assertEquals(driver.getCurrentUrl(), HomePageUrl.SEARCH_PAGE_URL.getUrl());
        softAssert.assertTrue(searchingPage.searchPageIsLoaded(), "Search page is not loaded");
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void verifySearchPageElements() throws InterruptedException {
        softAssert.assertTrue(searchingPage.searchPageIsLoaded(), "Search page is not loaded");
        Thread.sleep(10000);
        String pageTitle = searchingPage.getPageTitle();
        softAssert.assertEquals(pageTitle, "Categories", "Page title is not as expected");
        softAssert.assertAll();
        Thread.sleep(10000);
    }

    @Test(priority = 3)
    public void verifySearchFunctionality() throws InterruptedException {

        searchingPage.enterTextInSearchField("ՀՈԼ");
        Thread.sleep(5000);
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
        softAssert.assertEquals(driver.getCurrentUrl(), HomePageUrl.BOOK_PAGE_URL.getUrl());
        String titleOfTheResultPage = searchingPage.getTitleOfTheResultPage();
        softAssert.assertEquals(titleOfTheResultPage, "Հոլ");
        softAssert.assertAll();
    }
}

