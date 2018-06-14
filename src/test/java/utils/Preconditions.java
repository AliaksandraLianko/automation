package utils;

import businessobjects.User;
import factory.UserStaticFactory;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.LoginPage;
import services.LoginService;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Preconditions {

    private final String URL = "https://test-web1-17.corp.globoforce.com/microsites/t/home?client=recipientbased&setCAG=true";

    public void openClientSite() {
        driver.get(URL);
    }

    private static final int implicitTimeout = 15;
    protected WebDriver driver;

    @Parameters({"browser"})
    @BeforeClass
    public void start(@Optional(value = "chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(implicitTimeout, TimeUnit.SECONDS);
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(implicitTimeout, TimeUnit.SECONDS);
        } else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            driver.manage().timeouts().implicitlyWait(implicitTimeout, TimeUnit.SECONDS);
        }
        openClientSite();
        /*LoginPage loginPage = new LoginPage(driver);
        loginPage.openClientSite();*/
        User user = UserStaticFactory.createNominator();
        LoginService loginService = new LoginService(driver);
        loginService.loginToApp(user);
        //loginPage.logIn("norma_nominator", "pass");

    }


    @AfterClass
    public void closeDriver() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logOut();
        loginPage.logInAfterLogout();
        if (driver != null)
            driver.quit();
    }

    public WebElement waitElementAndClick(WebElement webElement) {
        return new WebDriverWait(driver, 10)
                .ignoring(StaleElementReferenceException.class)
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public WebElement waitElementPresent(final By by) {
        return new WebDriverWait(driver, 5)
                .pollingEvery(Duration.ofSeconds(1))
                .withMessage("Failed to wait element: " + by)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
