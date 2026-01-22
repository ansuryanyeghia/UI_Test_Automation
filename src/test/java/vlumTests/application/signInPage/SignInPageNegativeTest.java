package vlumTests.application.signInPage;

import application.signInPage.SignInPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import provider.UrlProvider;
import vlumTests.baseTest.BaseTest;

public class SignInPageNegativeTest extends BaseTest {

    SignInPage signInPage;

    @BeforeMethod
    public void goToUrl() {
        driver.get(UrlProvider.getSignInPageUrl());
        signInPage = new SignInPage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void validateSignInProcessWithInvalidCREDENTIALS() throws InterruptedException {
        signInPage.signInPageIsLoaded();

        Thread.sleep(2000);
        signInPage.enterEmail("@gmail.com");
        Thread.sleep(2000);
        signInPage.enterPassword("0000");
        Thread.sleep(2000);
        signInPage.pressSignInButton();
        waitHelper.waitUntilElementWillBeVisible(signInPage.errorMessage);
        String errorMessage = signInPage.getErrorMessage();
        softAssert.assertEquals(errorMessage, "Wrong credentials");
        Assertion assertion = new Assertion();
        assertion.assertEquals(driver.getCurrentUrl(), UrlProvider.getWelcomePageUrl());
    }
}
