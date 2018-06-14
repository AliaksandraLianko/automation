package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class LoginPage extends BasePage{

    @FindBy(name="username")
    private TextInput username;

    @FindBy(name="password")
    private TextInput password;

    @FindBy(id="signIn-button")
    private Button loginButton;

    @FindBy(xpath="//*[@class='container']/div[2]//li[5]/a")
    private Link logoutButton;

    @FindBy(xpath="//*[@id='signIn']//a")
    private Button loginAfterLogoutButton;

    private By xpath = By.xpath("//*[@id=\"navBar\"]//a[contains(@href,'dashboard')]");

    public void setUsername(String name) {
        username.sendKeys(name);
    }

    public void setPassword(String pswd) {
        password.sendKeys(pswd);
    }

    public void clickOnLoginButton() {
        loginButton.click();
        waitElementPresent(xpath);
    }

    public void logOut() {
        waitElementPresent(By.xpath("//*[@class='container']/div[2]//li[5]/a"));
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
