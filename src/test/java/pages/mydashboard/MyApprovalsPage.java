package pages.mydashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class MyApprovalsPage extends BasePage {

    private By approvalLightbox = By.id("unifiedAwardDetailsLightbox");
    private By approveNominationTitle = By.xpath("//*[contains(@id, 'unifiedAwardDetailsLightbox')]/div/h2");

    @FindBy(xpath="//div[contains(@class, 'approvals-section-header-text')]")
    private TextBlock myApprovalsTitle;

    @FindBy(xpath="//div[contains(@class, 'aurora approvals-section-group')]/div[2]/div")
    private TextBlock approvalCard;

    @FindBy(xpath="//div[contains(@class, 'award-card-body-container')]/div[1]/p[2]")
    private TextBlock nominationTitle;

    @FindBy(xpath="//span[contains(@class, 'award-card-award-value')]")
    private TextBlock awardValue;

    @FindBy(xpath="//p[contains(@class, 'award-card-award-title')]")
    private TextBlock awardTitle;

    @FindBy(xpath="//p[contains(@class, 'award-card-award-message')]")
    private TextBlock awardMessage;

    @FindBy(xpath="//div[contains(@class, 'award-card-continue-link')]/a")
    private Link viewNominationLink;

    @FindBy(xpath="//button[contains(@class, 'js-btn-approve')]")
    private Button approveButton;

    @FindBy(xpath="//button[contains(@class, 'js-btn-disapprove')]")
    private Button disapproveButton;

    public void clickViewNominationLink(){
        viewNominationLink.click();
        waitElementPresent(approvalLightbox);
        waitElementPresent(approveNominationTitle);
    }

    public String verifyApprovalsTitle() {
        return myApprovalsTitle.getText();
    }

    public boolean verifyApprovalCard() {
        return approvalCard.isDisplayed();
    }

    public String verifyNominationTitle() {
        return nominationTitle.getText();
    }

    public boolean verifyAwardValue() {
        return awardValue.isDisplayed();
    }

    public String verifyAwardTitle() {
        return awardTitle.getText();
    }

    public String verifyAwardMessage() {
        return awardMessage.getText();
    }

    public String verifyViewNominationLink() {
        return viewNominationLink.getText();
    }

    public String verifyApproveButton() {
        return approveButton.getText();
    }

    public String verifyDisapproveButton() {
        return disapproveButton.getText();
    }



    public MyApprovalsPage(WebDriver driver) {
        super(driver);
    }

}
