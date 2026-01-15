package vlumTests.application.homePage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlumTests.baseTest.BaseTest;
import vlume.application.homePage.HomePage;
import vlume.application.signIn.SignInPage;
import vlume.provider.urlPrividers.homeUrl.HomePageUrl;
import vlume.provider.urlPrividers.welcomeUrl.WelcomeUrl;

public class HomePageTests extends BaseTest {

    SignInPage signInPage;
    HomePage homePage;

    @BeforeClass
    public void goToUrl() {
        driver.get(WelcomeUrl.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void signInProcessWithValidCredentials() throws InterruptedException {
        signInPage.signInPageIsLoaded();
        signInPage.enterEmail("gyumrisymphony@gmail.com");
        signInPage.enterPassword("arm30Mozart");
        signInPage.pressSignInButton();
        Thread.sleep(3000);
        softAssert.assertEquals(driver.getCurrentUrl(), WelcomeUrl.WELCOME_PAGE_URL.getUrl());
    }

    @Test
    public void verifyHomePageElements() {
        waitHelper.waitUntilElementWillBeVisible(homePage.recentlyAddedPart);
        homePage.homePageIsLoaded();
        softAssert.assertTrue(homePage.recentlyAddedPart.isDisplayed(), "Recently Added");
        softAssert.assertTrue(homePage.illustratedBooksPart.isDisplayed(), "Illustrated Books");
        softAssert.assertAll();
    }

    @Test
    public void verifyPressOnTheSeeMoreForRecentlyAddedPart() {
        waitHelper.waitForElementToBeClickable(homePage.seeMoreForRecentlyAddedPart);
        homePage.pressOnTheSeeMoreForRecentlyAddedPart();
        softAssert.assertEquals(driver.getCurrentUrl(), HomePageUrl.RECENTLY_ADDED_URL.getUrl());
    }
}
