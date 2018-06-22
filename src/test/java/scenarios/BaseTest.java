package scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.CustomListener;

import java.util.concurrent.TimeUnit;

@Listeners(CustomListener.class)
public class BaseTest {

    private static final int IMPLICIT_TIMEOUT = 15;
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @Parameters({"browser"})
    @BeforeClass
    public void start(@Optional(value = "chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        } else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        }
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
