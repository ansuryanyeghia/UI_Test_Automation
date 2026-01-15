package vlumTests.baseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import vlume.driver.DriverFactory;
import vlume.helper.WaitHelper;

import static java.sql.DriverManager.getDriver;

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
