package vlumTests.application.signInPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import vlumTests.baseTest.BaseTest;
import vlume.application.homePage.HomePage;
import vlume.application.signIn.SignInPage;
import vlume.provider.urlPrividers.welcomeUrl.WelcomeUrl;

import java.io.IOException;

public class SignInPagePositiveTest extends BaseTest {

    SignInPage signInPage;
    HomePage homePage;

    @BeforeMethod
    public void goToUrl() {
        driver.get(WelcomeUrl.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void validateSignInProcess() throws InterruptedException, IOException {
        signInPage.signInPageIsLoaded();
        Thread.sleep(2000);
        signInPage.signIn();
        Assertion assertion = new Assertion();
        Thread.sleep(10000);
        assertion.assertEquals(driver.getCurrentUrl(), WelcomeUrl.WELCOME_PAGE_URL.getUrl());
    }
}
