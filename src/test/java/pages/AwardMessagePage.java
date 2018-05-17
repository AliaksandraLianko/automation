package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AwardMessagePage extends BasePage {

    @FindBy(id="np_awardTitle")
    private WebElement title;

    @FindBy(id="np_awardMessage")
    private WebElement messageToRecipient;

    @FindBy(id="np_messageForApproval")
    private WebElement messageToAprover;

    @FindBy(xpath="//*[@id='np_sideSection']/div[2]/button")
    private WebElement sendAwardButton;

    @FindBy(xpath="//*[@class='np-confirmation-holder']/div[2]/button")
    private WebElement closeButton;

    @FindBy(xpath="//*[@class='np-confirmation-message']")
    private WebElement confirmationText;

    @FindBy(xpath="//div[@class='np-award-reason-info']")
    private WebElement selectedReason;

    @FindBy(xpath="//*[@id='np_sideAddDetails']//ul//div[1]")
    private WebElement selectedAwardValue;

    public void addTitle(String titleText) {
        title.sendKeys(titleText);
        waitElementPresent(By.id("np_awardMessage"));
    }

    public void addMessageToRecipient(String recipientMessage) {
        messageToRecipient.sendKeys(recipientMessage);
        waitElementPresent(By.id("np_messageForApproval"));
    }

    public void addMessageToApprover(String approverMessage) throws InterruptedException {
        messageToAprover.sendKeys(approverMessage);
        waitElementPresent(By.xpath("//*[@id='np_sideSection']/div[1]/button"));
        Thread.sleep(2000);
    }

    public void clickSendAward() throws InterruptedException {
        sendAwardButton.click();
        waitElementPresent(By.className("np-confirmation-message"));
        Thread.sleep(2000);
    }


    public void clickClose() throws InterruptedException{
        closeButton.click();
        waitElementPresent(By.className("np-confirmation-message"));
        Thread.sleep(2000);
    }

    public String getConfirmationText() {
        return confirmationText.getText();
    }

    public String getSelectedReason() {
        return selectedReason.getText();
    }

    public String getSelectedAwardValue() {
        return selectedAwardValue.getText();
    }

    public AwardMessagePage(WebDriver driver) {
        super(driver);
    }
}
