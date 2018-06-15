package services;

import businessobjects.User;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginService {

    private WebDriver driver;

    public LoginService(WebDriver driver) {
        this.driver = driver;
    }

    private final String URL = "https://test-web1-17.corp.globoforce.com/microsites/t/home?client=recipientbased&setCAG=true";

    public void openClientSite() {
        this.driver.get(URL);
    }

    public void loginToApp(User user) {
        openClientSite();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername(user.getUsername());
        loginPage.setPassword(user.getPassword());
        loginPage.clickOnLoginButton();
    }
}
