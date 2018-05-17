package scenarios;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.Preconditions;


public class MyNominationsTest extends Preconditions  {

    @Test(priority = 0)
    public void verifyMyNominationsPage() throws InterruptedException{
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.goToMyDashboard();
        MyDashboardMenuPage myDashboardMenuPage = new MyDashboardMenuPage(driver);
        myDashboardMenuPage.goToMyNominations();
        MyNominationsPage myNominationsPage = new MyNominationsPage(driver);
        Assert.assertEquals(myNominationsPage.verifyDate(), "Date");
        Assert.assertEquals(myNominationsPage.verifyAwardType(), "Award Type");
        Assert.assertEquals(myNominationsPage.verifyRecipient(), "Recipient");
        Assert.assertEquals(myNominationsPage.verifyStatus(), "Status");
        Assert.assertEquals(myNominationsPage.verifyAwardAmount(), "Award Amount");
        myNominationsPage.openNominationDetailsLightbox();
        NominationDetailsLightbox nominationDetailsLightbox = new NominationDetailsLightbox(driver);
        Assert.assertEquals(nominationDetailsLightbox.verifyNominationDetailsTitle(), "Nomination Details");
        Assert.assertEquals(nominationDetailsLightbox.verifyDate(), "Date Nominated");
        //Assert.assertEquals(nominationDetailsLightbox.verifyDateValue(), "");
        Assert.assertEquals(nominationDetailsLightbox.verifyType(), "Award Type");
        Assert.assertEquals(nominationDetailsLightbox.verifyTypeValue(), "Award2");
        Assert.assertEquals(nominationDetailsLightbox.verifyReason(), "Award Reason");
        Assert.assertEquals(nominationDetailsLightbox.verifyReasonValue(), "REASON3");
        Assert.assertEquals(nominationDetailsLightbox.verifyDepartment(), "Department");
        Assert.assertEquals(nominationDetailsLightbox.verifyDepartmentValue(), "Office of the CEO");
        Assert.assertEquals(nominationDetailsLightbox.verifyAwardTitle(), "Award Title");
        Assert.assertEquals(nominationDetailsLightbox.verifyAwardTitleValue(), "Test award title");
        Assert.assertEquals(nominationDetailsLightbox.verifyNominator(), "Nominator");
        Assert.assertEquals(nominationDetailsLightbox.verifyNominatorValue(), "Norma Nominator");
        Assert.assertEquals(nominationDetailsLightbox.verifyCurrentApprover(), "Current Approver");
        Assert.assertEquals(nominationDetailsLightbox.verifyCurrentApproverValue(), "Manfred Manager2");
        Assert.assertEquals(nominationDetailsLightbox.verifyStatus(), "Status");
        Assert.assertEquals(nominationDetailsLightbox.verifyStatusValue(), "Pending");
        Assert.assertEquals(nominationDetailsLightbox.verifySubmittedBy(), "Submitted By");
        Assert.assertEquals(nominationDetailsLightbox.verifySubmittedByValue(), "Norma Nominator");
        Assert.assertEquals(nominationDetailsLightbox.verifyPrivacy(), "Privacy Level");
        Assert.assertEquals(nominationDetailsLightbox.verifyPrivacyValue(), "Shared\n" +
                "Shared - display on Company Awards Feed");
        Assert.assertEquals(nominationDetailsLightbox.verifyMessageToApprover(), "Message to Approving Manager");
        Assert.assertEquals(nominationDetailsLightbox.verifyMessageToApproverValue(), "Test message for approver");
        Assert.assertEquals(nominationDetailsLightbox.verifyMessageToRecipient(), "Message to Recipient");
        Assert.assertEquals(nominationDetailsLightbox.verifyMessageToRecipientValue(), "Test message to recipient");
        Assert.assertEquals(nominationDetailsLightbox.verifyRecipientsTab(), "RECIPIENTS");
        Assert.assertEquals(nominationDetailsLightbox.verifyApproversTab(), "APPROVERS");
        Assert.assertEquals(nominationDetailsLightbox.verifyHistoryTab(), "HISTORY");
        nominationDetailsLightbox.closeNominationDetailsLightbox();

    }


}
