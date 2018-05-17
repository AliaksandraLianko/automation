package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyDashboardMenuPage extends BasePage {


    @FindBy(xpath="//*//a[contains(@href,'MyNominations')]")
    private WebElement myNominations;

    public void goToMyNominations(){
        myNominations.click();
        waitElementPresent(By.className("nominations-title"));
    }

    public MyDashboardMenuPage(WebDriver driver) {
        super(driver);
    }
}
