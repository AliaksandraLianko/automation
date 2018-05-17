package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectRecipientPage extends BasePage{
    @FindBy(xpath="//*[@id='np-select-recipient-content']/div[2]/ul[3]/li[1]")
    private WebElement recipient;

    @FindBy(xpath="//*[@id='np_sideSection']/div[1]/button")
    private WebElement nextButton;

    public void selectRecipient() {
        recipient.click();
        waitElementPresent(By.xpath("//*[@id='np_sideSection']/div[1]/button"));
    }

    public void clickNext() throws InterruptedException{
        nextButton.click();
        waitElementPresent(By.xpath("//*[@class='np-award-programs-list']"));
        Thread.sleep(2000);
    }

    public SelectRecipientPage(WebDriver driver) {
        super(driver);
    }
}
