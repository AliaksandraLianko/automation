package scenarios;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.LoginPage;
import utils.DriverInstance;
import utils.DriverInstanceFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static final int IMPLICIT_TIMEOUT = 15;
    private static WebDriver driver;
    private DriverInstance driverInstance;

    protected WebDriver getDriver() {
        return driver;
    }

    @Parameters({"browser"})
    @BeforeClass
    public void start(@Optional(value = "chrome") String browser) {
        driverInstance = DriverInstanceFactory.getBrowser(browser);
        driver = driverInstance.getInstance();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void closeDriver() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logOut();
        loginPage.logInAfterLogout();
        if (driver != null)
            driver.quit();
    }
}
