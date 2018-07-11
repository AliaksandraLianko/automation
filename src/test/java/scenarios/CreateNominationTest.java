package scenarios;

import businessobjects.NominationDetails;
import factory.NominationStaticFactory;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import pages.nomination.*;
import services.NominationService;


public class CreateNominationTest extends BaseNominatorTest {
    private Logger logger = Logger.getLogger(getClass());

    @Test(priority = -1)
    public void createNomination() throws InterruptedException{
        TopMenuPage topMenuPage = new TopMenuPage(getDriver());
        logger.info("Click Recognize link");
        topMenuPage.clickRecognize();
        SelectRecipientPage selectRecipientPage = new SelectRecipientPage(getDriver());
        logger.info("Select recipient");
        selectRecipientPage.selectRecipient();
        selectRecipientPage.clickNext();
        SelectProgramPage selectProgramPage = new SelectProgramPage(getDriver());
        Assert.assertEquals(selectProgramPage.getInfoText(), "You are not nominating Mandy Manager1");
        logger.info("Select award program");
        selectProgramPage.selectProgram();
        SelectReasonPage selectReasonPage = new SelectReasonPage(getDriver());
        Assert.assertEquals(selectReasonPage.getSelectedProgram(), "recipientbased program");
        logger.info("Select award reason");
        selectReasonPage.selectReason();
        AwardAdvisorPage awardAdvisorPage = new AwardAdvisorPage(getDriver());
        logger.info("Skip award advisor");
        awardAdvisorPage.skipAwardAdvisor();
        SelectAwardValuePage selectAwardValuePage = new SelectAwardValuePage(getDriver());
        logger.info("Select award level");
        selectAwardValuePage.selectAwardLevel();
        AwardMessagePage awardMessagePage = new AwardMessagePage(getDriver());
        //Assert.assertEquals(awardMessagePage.getSelectedReason(), "REASON3");
        Assert.assertEquals(awardMessagePage.getSelectedAwardValue(), "Award2 GBP 35");
        NominationDetails nomination = NominationStaticFactory.populateNomination();
        NominationService nominationService = new NominationService(getDriver());
        logger.info("Populate nomination fields and send award");
        nominationService.populateAwardFields(nomination);
        Assert.assertEquals(awardMessagePage.getConfirmationText(), "Thanks for taking the time to recognize a colleague.\n" +
                "It's an important part of our culture.");
        logger.info("Close nomination panel");
        awardMessagePage.clickClose();


    }

}
