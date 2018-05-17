package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuPage extends BasePage {


    @FindBy(xpath="//*[@id=\"navBar\"]//a[contains(@href,'dashboard')]")
    private WebElement dashboard;

    @FindBy(id="np_start")
    private WebElement recognize;

    public void goToMyDashboard(){
        dashboard.click();
        waitElementPresent(By.xpath("//*//a[contains(@href,'MyNominations')]"));
    }

    public void clickRecognize() throws InterruptedException{
        recognize.click();
        waitElementPresent(By.xpath("//div[@id='np-select-recipient-content']/div[2]/ul[3]/li[1]"));
        Thread.sleep(3000);
    }

     public TopMenuPage(WebDriver driver) {
        super(driver);
    }
}
