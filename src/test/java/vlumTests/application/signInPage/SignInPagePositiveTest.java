package vlumTests.application.signInPage;

import application.homePage.HomePage;
import application.signInPage.SignInPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import provider.UrlProvider;
import vlumTests.baseTest.BaseTest;

import java.io.IOException;

public class SignInPagePositiveTest extends BaseTest {

    SignInPage signInPage;
    HomePage homePage;

    @BeforeMethod
    public void goToUrl() {
        driver.get(UrlProvider.getSignInPageUrl());
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();
    }

    @Test(groups = {"Smock"})
    public void validateSignInProcess() throws IOException {
        signInPage.signInPageIsLoaded();
        signInPage.signIn();
        Assertion assertion = new Assertion();
        homePage.homePageIsLoaded();
        assertion.assertEquals(driver.getCurrentUrl(), UrlProvider.getWelcomePageUrl());
    }
}
