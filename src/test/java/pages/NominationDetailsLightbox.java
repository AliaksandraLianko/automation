package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NominationDetailsLightbox extends BasePage {
    @FindBy(xpath="//*[@id='panel']/div/div/div/h1")
    private WebElement nominationDetailsTitle;

    @FindBy(xpath="//*[@id='panel']//div/table[1]/tbody/tr[1]/th[1]")
    private WebElement date;

    @FindBy(xpath="//*[@id='panel']/div//table[1]/tbody/tr[1]/td[1]")
    private WebElement dateValue;

    @FindBy(xpath="//*[@id='panel']/div//table[1]/tbody/tr[2]/th[1]")
    private WebElement awardType;

    @FindBy(xpath="//*[@id='panel']//div/table[1]/tbody/tr[2]/td[1]")
    private WebElement awardTypeValue;

    @FindBy(xpath="//*[@id='panel']//div/table[1]/tbody/tr[3]/th[1]")
    private WebElement reason;

    @FindBy(xpath="//*[@id='panel']//div/table[1]/tbody/tr[3]/td[1]")
    private WebElement reasonValue;

    @FindBy(xpath="//*[@id='panel']//div/table[1]/tbody/tr[4]/th[1]")
    private WebElement department;

    @FindBy(xpath="//*[@id='panel']//div/table[1]/tbody/tr[4]/td[1]")
    private WebElement departmentValue;

    @FindBy(xpath="//*[@id='panel']//div/table[1]/tbody/tr[5]/th[1]")
    private WebElement awardTitle;

    @FindBy(xpath="//*[@id='panel']//div/table[1]/tbody/tr[5]/td[1]")
    private WebElement awardTitleValue;

    @FindBy(xpath="//*[@id='panel']//div/table[1]/tbody/tr[1]/th[2]")
    private WebElement nominator;

    @FindBy(xpath="//*[@id='panel']//div/table[1]/tbody/tr[1]/td[2]")
    private WebElement nominatorValue;

    @FindBy(xpath="//*[@id='panel']//div/table[1]/tbody/tr[2]/th[2]")
    private WebElement currentApprover;

    @FindBy(xpath="//*[@id='panel']//div/table[1]/tbody/tr[2]/td[2]")
    private WebElement currentApproverValue;

    @FindBy(xpath="//*[@id='panel']//div/table[1]/tbody/tr[3]/th[2]")
    private WebElement status;

    @FindBy(xpath="//*[@id='panel']//div/table[1]/tbody/tr[3]/td[2]")
    private WebElement statusValue;

    @FindBy(xpath="//*[@id='panel']//div/table[1]/tbody/tr[4]/th[2]")
    private WebElement submittedBy;

    @FindBy(xpath="//*[@id='panel']//div/table[1]/tbody/tr[4]/td[2]")
    private WebElement submittedByValue;

    @FindBy(xpath="//*[@id='panel']//div/table[1]/tbody/tr[5]/th[2]")
    private WebElement privacy;

    @FindBy(xpath="//*[@id='panel']//div/table[1]/tbody/tr[5]/td[2]")
    private WebElement privacyValue;

    @FindBy(xpath="//*[@id='panel']/div//table[2]/tbody/tr[1]/th")
    private WebElement messageToApprover;

    @FindBy(xpath="//*[@id='panel']/div//table[2]/tbody/tr[1]/td")
    private WebElement messageToApproverValue;

    @FindBy(xpath="//*[@id='panel']/div//table[2]/tbody/tr[2]/th")
    private WebElement messageToRecipient;

    @FindBy(xpath="//*[@id='panel']/div//table[2]/tbody/tr[2]/td")
    private WebElement messageToRecipientValue;

    @FindBy(xpath="//*[@id='recipientsTab']/a")
    private WebElement recipientsTab;

    @FindBy(xpath="//*[@id='approversTab']/a")
    private WebElement approversTab;

    @FindBy(xpath="//*[@id='historyTab']/a")
    private WebElement historyTab;

    @FindBy(xpath="//a[@class='container-close']")
    private WebElement closeIcon;

    public String verifyNominationDetailsTitle() {
        return nominationDetailsTitle.getText();
    }

    public String verifyDate() {
        return date.getText();
    }

    public String verifyDateValue() {
        return dateValue.getText();
    }

    public String verifyType() {
        return awardType.getText();
    }

    public String verifyTypeValue() {
        return awardTypeValue.getText();
    }

    public String verifyReason() {
        return reason.getText();
    }

    public String verifyReasonValue() {
        return reasonValue.getText();
    }

    public String verifyDepartment() {
        return department.getText();
    }

    public String verifyDepartmentValue() {
        return departmentValue.getText();
    }

    public String verifyAwardTitle() {
        return awardTitle.getText();
    }

    public String verifyAwardTitleValue() {
        return awardTitleValue.getText();
    }

    public String verifyNominator() {
        return nominator.getText();
    }

    public String verifyNominatorValue() {
        return nominatorValue.getText();
    }

    public String verifyCurrentApprover() {
        return currentApprover.getText();
    }

    public String verifyCurrentApproverValue() {
        return currentApproverValue.getText();
    }

    public String verifyStatus() {
        return status.getText();
    }

    public String verifyStatusValue() {
        return statusValue.getText();
    }

    public String verifySubmittedBy() {
        return submittedBy.getText();
    }

    public String verifySubmittedByValue() {
        return submittedByValue.getText();
    }

    public String verifyPrivacy() {
        return privacy.getText();
    }

    public String verifyPrivacyValue() {
        return privacyValue.getText();
    }

    public String verifyMessageToApprover() {
        return messageToApprover.getText();
    }

    public String verifyMessageToApproverValue() {
        return messageToApproverValue.getText();
    }

    public String verifyMessageToRecipient() {
        return messageToRecipient.getText();
    }

    public String verifyMessageToRecipientValue() {
        return messageToRecipientValue.getText();
    }

    public String verifyRecipientsTab() {
        return recipientsTab.getText();
    }

    public String verifyApproversTab() {
        return approversTab.getText();
    }

    public String verifyHistoryTab() {
        return historyTab.getText();
    }

    public void closeNominationDetailsLightbox() throws InterruptedException{
        closeIcon.click();
        Thread.sleep(2000);
    }
    public NominationDetailsLightbox(WebDriver driver) {
        super(driver);
    }
}
