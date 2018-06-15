package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.*;

public class ApprovalLightbox extends BasePage {

    @FindBy(xpath="//*[contains(@id, 'unifiedAwardDetailsLightbox')]/div/h2")
    private TextBlock nominationDetailsTitle;

    @FindBy(xpath="//*[contains(@class, 'award-lightbox-info-inner')]/h2")
    private TextBlock awardTitle;

    @FindBy(xpath="//p[contains(@class, 'award-lightbox-message')]")
    private TextBlock awardMessage;

    @FindBy(xpath="//span[contains(@class, 'ui-selectmenu-text')]")
    private Select awardValue;

    @FindBy(xpath="//*[contains(@class, 'award-lightbox-msg-approver-inner')]/h2")
    private TextBlock messageToApprover;

    @FindBy(xpath="//*[contains(@class, 'award-lightbox-msg-approver-inner')]/p")
    private TextBlock messageToApproverValue;

    @FindBy(xpath="//span[contains(@class, 'privacy-label')]")
    private Link privacy;

    @FindBy(id = "al-addcongratulation-textarea")
    private TextInput congratulationField;

    @FindBy(id="approvalPanel-approveButton")
    private Button approveButton;

    @FindBy(id="approvalPanel-disapproveButton")
    private Button disapproveButton;

    public String verifyNominationDetailsTitle() {
        return nominationDetailsTitle.getText();
    }

    public String verifyAwardTitle() {
        return awardTitle.getText();
    }

    public String verifyAwardMessage() {
        return awardMessage.getText();
    }

    public boolean verifyAwardValue() {
        return awardValue.isDisplayed();
    }

    public String verifyMessageToApprover() {
        return messageToApprover.getText();
    }

    public String verifyMessageToApproverValue() {
        return messageToApproverValue.getText();
    }

    public String verifyPrivacy() {
        return privacy.getText();
    }

    public boolean verifyCongratulationField() {
        return congratulationField.isDisplayed();
    }

    public String verifyApproveButton() {
        return approveButton.getText();
    }

    public String verifyDisapproveButton() {
        return disapproveButton.getText();
    }

    public void approveNomination(){
        approveButton.click();
    }


    public ApprovalLightbox(WebDriver driver) {
        super(driver);
    }
}
