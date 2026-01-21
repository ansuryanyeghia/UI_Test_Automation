package vlume.application.signIn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vlume.basePage.BasePage;
import vlume.models.User;
import vlume.provider.userPrivider.UserProvider;

import java.io.IOException;

public class SignInPage extends BasePage {

    UserProvider userProvider;

    @FindBy(xpath = "//input[@formcontrolname='username']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//div/button[@id='loginButton']")
    public WebElement signInButton;

    @FindBy(xpath = "//*[@id='cdk-overlay-8']/snack-bar-container")
    public WebElement errorMessage;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        this.emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        this.passwordField.sendKeys(password);
    }

    public void pressSignInButton() {
        this.signInButton.click();
    }

    public String getErrorMessage() {
         return this.errorMessage.getText();
    }

    public void signIn() throws IOException {
        userProvider = new UserProvider();
        User validUser = userProvider.createValidUser();
        String userEmail = validUser.getEmail();
        String userPassword = validUser.getPassword();

        waitHelper.waitUntilAllElementsToBeVisible(this.emailField, this.passwordField, this.signInButton);
        this.emailField.sendKeys(userEmail);
        this.passwordField.sendKeys(userPassword);
        this.signInButton.click();

    }

    public boolean signInPageIsLoaded() {
        return super.pageIsLoaded(this.emailField, this.passwordField, this.signInButton);
    }
}
