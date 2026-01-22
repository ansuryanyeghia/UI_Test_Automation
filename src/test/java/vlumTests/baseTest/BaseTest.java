package vlumTests.baseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import driver.DriverFactory;
import helper.WaitHelper;


public class BaseTest extends DriverFactory {
    protected WebDriver driver;
    protected WaitHelper waitHelper;
    protected SoftAssert softAssert;

    @BeforeClass
    public void setup() {
        driver = getDriver();
        waitHelper = new WaitHelper(driver);
    }


}
