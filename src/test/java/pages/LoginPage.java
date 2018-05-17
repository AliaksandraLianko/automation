package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    private final String URL = "https://test-web1-17.corp.globoforce.com/microsites/t/home?client=recipientbased&setCAG=true";

    @FindBy(name="username")
    private WebElement username;

    @FindBy(name="password")
    private WebElement password;

    @FindBy(id="signIn-button")
    private WebElement loginButton;

    @FindBy(xpath="//*[@class='container']/div[2]//li[5]/a")
    private WebElement logoutButton;

    @FindBy(xpath="//*[@id='signIn']//a")
    private WebElement loginAfterLogoutButton;

    public void openClientSite() {
        getWebDriver().get(URL);
        waitElementPresent(By.name("username"));
    }

    public void logIn(String user, String pass){
        username.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();
        waitElementPresent(By.xpath("//*[@id=\"navBar\"]//a[contains(@href,'dashboard')]"));
    }

    public void logOut() {
        logoutButton.click();
        waitElementPresent(By.id("signIn"));
    }

    public void logInAfterLogout() {
        loginAfterLogoutButton.click();
        waitElementPresent(By.name("username"));
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
