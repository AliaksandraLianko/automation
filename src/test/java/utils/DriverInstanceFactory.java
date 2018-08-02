package utils;


public class DriverInstanceFactory {

    public static DriverInstance getBrowser(String browser) {
        DriverInstance driverInstance = null;
        if (browser.equalsIgnoreCase("chrome")) {
            driverInstance = new Chrome();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driverInstance = new Firefox();
        } else if(browser.equalsIgnoreCase("ie")) {
            driverInstance = new IE();
        }
        return driverInstance;
    }
}
