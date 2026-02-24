package vlumTests.baseTest;

import driver.DriverFactory;
import helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;


public class BaseTest extends DriverFactory {
    protected WebDriver driver;
    protected WaitHelper waitHelper;
    protected SoftAssert softAssert;

    @BeforeClass
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) {
        createDriver(browser);
        driver = getDriver();
        waitHelper = new WaitHelper(driver);
        softAssert = new SoftAssert();
    }

    @AfterClass
    public void tearDown() {
        quitDriver();
    }


}
