package pages.nomination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class AwardMessagePage extends BasePage {

    @FindBy(id="np_awardTitle")
    private TextInput title;

    @FindBy(id="np_awardMessage")
    private TextInput messageToRecipient;

    @FindBy(id="np_messageForApproval")
    private TextInput messageToAprover;

    @FindBy(xpath="//*[@id='np_sideSection']/div[2]/button")
    private Button sendAwardButton;

    @FindBy(xpath="//*[@class='np-confirmation-holder']/div[2]/button")
    private Link closeButton;

    @FindBy(xpath="//*[@class='np-confirmation-message']")
    private TextBlock confirmationText;

    @FindBy(xpath="//div[@class='np-award-reason-info']")
    private TextBlock selectedReason;

    @FindBy(xpath="//*[@id='np_sideAddDetails']//ul//div[1]")
    private TextBlock selectedAwardValue;

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
