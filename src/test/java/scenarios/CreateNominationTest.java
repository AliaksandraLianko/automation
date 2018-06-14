package scenarios;

import businessobjects.NominationDetails;
import factory.NominationStaticFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import pages.nomination.*;
import services.NominationService;


public class CreateNominationTest extends BaseNominatorTest {

    @Test(priority = -1)
    public void createNomination() throws InterruptedException{
        TopMenuPage topMenuPage = new TopMenuPage(getDriver());
        topMenuPage.clickRecognize();
        SelectRecipientPage selectRecipientPage = new SelectRecipientPage(getDriver());
        selectRecipientPage.selectRecipient();
        selectRecipientPage.clickNext();
        SelectProgramPage selectProgramPage = new SelectProgramPage(getDriver());
        Assert.assertEquals(selectProgramPage.getInfoText(), "You are nominating Mandy Manager1");
        selectProgramPage.selectProgram();
        SelectReasonPage selectReasonPage = new SelectReasonPage(getDriver());
        Assert.assertEquals(selectReasonPage.getSelectedProgram(), "recipientbased program");
        selectReasonPage.selectReason();
        AwardAdvisorPage awardAdvisorPage = new AwardAdvisorPage(getDriver());
        awardAdvisorPage.skipAwardAdvisor();
        SelectAwardValuePage selectAwardValuePage = new SelectAwardValuePage(getDriver());
        selectAwardValuePage.selectAwardLevel();
        AwardMessagePage awardMessagePage = new AwardMessagePage(getDriver());
        //Assert.assertEquals(awardMessagePage.getSelectedReason(), "REASON3");
        Assert.assertEquals(awardMessagePage.getSelectedAwardValue(), "Award2 GBP 35");
        NominationDetails nomination = NominationStaticFactory.populateNomination();
        NominationService nominationService = new NominationService(getDriver());
        nominationService.populateAwardFields(nomination);
        Assert.assertEquals(awardMessagePage.getConfirmationText(), "Thanks for taking the time to recognize a colleague.\n" +
                "It's an important part of our culture.");
        awardMessagePage.clickClose();


    }

}
