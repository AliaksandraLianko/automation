package utils;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriverHelper {
    protected WebDriver driver;
    private final String URL = "http://192.168.56.1:4444/wd/hub";

    @BeforeClass
    public void startRemoteDriver() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        String browserName = System.getProperty("browserName");
        cap.setBrowserName(browserName);
        cap.setPlatform(Platform.fromString("WINDOWS"));
        URL url = new URL(URL);
        driver = new RemoteWebDriver(url, cap);
    }

    @AfterClass
    public void quiteDriver(){
        driver.quit();
    }
}
