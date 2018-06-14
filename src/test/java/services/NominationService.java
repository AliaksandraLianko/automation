package services;

import businessobjects.NominationDetails;
import org.openqa.selenium.WebDriver;
import pages.nomination.AwardMessagePage;

public class NominationService {
    private WebDriver driver;

    public NominationService(WebDriver driver) {
        this.driver = driver;
    }

    public void populateAwardFields(NominationDetails nominationDetails) throws InterruptedException{
        AwardMessagePage awardMessagePage = new AwardMessagePage(driver);
        awardMessagePage.addTitle(nominationDetails.getAwardTitle());
        awardMessagePage.addMessageToRecipient(nominationDetails.getAwardMessage());
        awardMessagePage.addMessageToApprover(nominationDetails.getMesageToApprover());
        awardMessagePage.clickSendAward();
    }
}
