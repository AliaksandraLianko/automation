package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AwardAdvisorPage extends BasePage {
    @FindBy(xpath="//*[@class='np-program-advisor']//a")
    private WebElement skipAdvisor;

    public void skipAwardAdvisor() throws InterruptedException {
        skipAdvisor.click();
        waitElementPresent(By.xpath("//div[@class='np-program-advisor']//a"));
        Thread.sleep(2000);
    }

    public AwardAdvisorPage(WebDriver driver) {
        super(driver);
    }
}
