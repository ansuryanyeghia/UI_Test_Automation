package vlumTests.application.signInPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import vlumTests.baseTest.BaseTest;
import vlume.application.homePage.HomePage;
import vlume.application.signIn.SignInPage;
import vlume.provider.urlPrividers.welcomeUrl.WelcomeUrl;

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
    public void validateSignInProcess() throws InterruptedException {
        signInPage.signInPageIsLoaded();
        Thread.sleep(2000);
        signInPage.enterEmail("gyumrisymphony@gmail.com");
        Thread.sleep(2000);
        signInPage.enterPassword("arm30Mozart");
        Thread.sleep(2000);
        signInPage.pressSignInButton();
        Thread.sleep(2000);
        Assertion assertion = new Assertion();
        assertion.assertEquals(driver.getCurrentUrl(), WelcomeUrl.WELCOME_PAGE_URL.getUrl());
    }
}
