package utils;

import org.openqa.selenium.WebDriver;

public abstract class DriverInstance {
    protected WebDriver driver;
    protected abstract void createDriverInstance();
    public WebDriver getInstance() {
        if (null == driver) {
            createDriverInstance();
        }
        return driver;
    }
}
