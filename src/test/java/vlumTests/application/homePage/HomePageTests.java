package vlumTests.application.homePage;

import application.homePage.HomePage;
import application.signInPage.SignInPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import provider.UrlProvider;
import vlumTests.baseTest.BaseTest;

import java.io.IOException;

public class HomePageTests extends BaseTest {

    SignInPage signInPage;
    HomePage homePage;

    @BeforeClass
    public void goToUrl() {
        driver.get(UrlProvider.getSignInPageUrl());
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void signInProcessWithValidCredentials() throws IOException {
        signInPage.signInPageIsLoaded();
        signInPage.signIn();
        homePage.homePageIsLoaded();
        softAssert.assertEquals(driver.getCurrentUrl(), UrlProvider.getWelcomePageUrl());
    }

    @Test(groups = {"Smock"})
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
        softAssert.assertEquals(driver.getCurrentUrl(), UrlProvider.getRecentlyAddedUrl());
    }
}
