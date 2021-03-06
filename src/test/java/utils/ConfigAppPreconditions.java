package utils;

import com.sun.javafx.runtime.SystemProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ConfigAppPreconditions{
    private static final int implicitTimeout = 15;
    protected WebDriver driver;

//    @Parameters({"browser"})
    @BeforeClass
    public void start(/*@Optional(value = "chrome") String browser*/) {
        String browser = System.getProperty("browserName");
        System.out.println("Current browser:" + browser);
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
    }

    @AfterClass
    public void closeDriver() {
        if (driver != null)
            driver.quit();
    }

    public WebElement waitElementPresent(final By by) {
        return new WebDriverWait(driver, 5)
                .pollingEvery(Duration.ofSeconds(1))
                .withMessage("Failed to wait element: " + by)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
