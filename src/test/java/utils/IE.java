package utils;

import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class IE extends DriverInstance {
    @Override
    protected void createDriverInstance() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}
