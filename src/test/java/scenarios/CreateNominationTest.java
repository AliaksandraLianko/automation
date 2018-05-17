package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.Preconditions;

public class CreateNominationTest extends Preconditions {
    @Test(priority = -1)
    public void createNomination() throws InterruptedException{
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.openClientSite();
//        loginPage.logIn("norma_nominator", "pass");
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickRecognize();
        SelectRecipientPage selectRecipientPage = new SelectRecipientPage(driver);
        selectRecipientPage.selectRecipient();
        selectRecipientPage.clickNext();
        SelectProgramPage selectProgramPage = new SelectProgramPage(driver);
        Assert.assertEquals(selectProgramPage.getInfoText(), "You are nominating Mandy Manager1");
        selectProgramPage.selectProgram();
        SelectReasonPage selectReasonPage = new SelectReasonPage(driver);
        Assert.assertEquals(selectReasonPage.getSelectedProgram(), "recipientbased program");
        selectReasonPage.selectReason();
        AwardAdvisorPage awardAdvisorPage = new AwardAdvisorPage(driver);
        awardAdvisorPage.skipAwardAdvisor();
        SelectAwardValuePage selectAwardValuePage = new SelectAwardValuePage(driver);
        selectAwardValuePage.selectAwardLevel();
        AwardMessagePage awardMessagePage = new AwardMessagePage(driver);
        //Assert.assertEquals(awardMessagePage.getSelectedReason(), "REASON3");
        Assert.assertEquals(awardMessagePage.getSelectedAwardValue(), "Award2 GBP 35");
        awardMessagePage.addTitle("Test award title");
        awardMessagePage.addMessageToRecipient("Test message to recipient");
        awardMessagePage.addMessageToApprover("Test message for approver");
        awardMessagePage.clickSendAward();
        Assert.assertEquals(awardMessagePage.getConfirmationText(), "Thanks for taking the time to recognize a colleague.\n" +
                "It's an important part of our culture.");
        awardMessagePage.clickClose();
//        loginPage.logOut();
//        loginPage.logInAfterLogout();

    }

}
