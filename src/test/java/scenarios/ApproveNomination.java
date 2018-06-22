package scenarios;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ApprovalLightbox;
import pages.TopMenuPage;
import pages.mydashboard.MyApprovalsPage;
import pages.mydashboard.MyDashboardMenuPage;

public class ApproveNomination extends BaseApproverTest{
    private Logger logger = Logger.getLogger(getClass());

    @Test(priority = 1)
    public void approveNomination() throws InterruptedException {
        TopMenuPage topMenuPage = new TopMenuPage(getDriver());
        logger.info("Navigate My Dashboard");
        topMenuPage.goToMyDashboard();
        MyDashboardMenuPage myDashboardMenuPage = new MyDashboardMenuPage(getDriver());
        logger.info("Navigate to My Approvals");
        myDashboardMenuPage.goToMyApprovals();
        MyApprovalsPage myApprovalsPage = new MyApprovalsPage(getDriver());
        //Assert.assertEquals(myApprovalsPage.getApprovalsTitle(), "My Approvals");
        /*StringBuilder myApprovalsPageErrorStack = verifyMyApprovalsPage();
        Assert.assertTrue(myApprovalsPageErrorStack.length() == 0, myApprovalsPageErrorStack.toString());*/
        SoftAssert assert1 = new SoftAssert();
        assert1.assertEquals(myApprovalsPage.getApprovalsTitle(), "My Approvals");
        Thread.sleep(5000);
        Assert.assertEquals(myApprovalsPage.verifyNominationTitle(), "Norma Nominator nominated\n" +
                "Mandy Manager1");
        Assert.assertTrue(myApprovalsPage.verifyApprovalCard());
        Assert.assertTrue(myApprovalsPage.verifyAwardValue());
        Assert.assertEquals(myApprovalsPage.verifyAwardTitle(), "Test award title");
        Assert.assertEquals(myApprovalsPage.verifyAwardMessage(), "Test message to recipient");
        Assert.assertEquals(myApprovalsPage.verifyViewNominationLink(), "View Nomination");
        Assert.assertEquals(myApprovalsPage.verifyApproveButton(), "Approve");
        Assert.assertEquals(myApprovalsPage.verifyDisapproveButton(), "Disapprove");
        logger.info("Open Nomination Details lightbox");
        myApprovalsPage.clickViewNominationLink();
        ApprovalLightbox approvalLightbox = new ApprovalLightbox(getDriver());
        Assert.assertEquals(approvalLightbox.verifyNominationDetailsTitle(), "Norma Nominator nominated Mandy Manager1");
        Assert.assertEquals(approvalLightbox.verifyAwardTitle(), "Test award title");
        Assert.assertEquals(approvalLightbox.verifyAwardMessage(), "Test message to recipient");
        Assert.assertTrue(approvalLightbox.verifyAwardValue());
        Assert.assertEquals(approvalLightbox.verifyMessageToApprover(), "Message to Approver");
        Assert.assertEquals(approvalLightbox.verifyMessageToApproverValue(), "Test message for approver");
        Assert.assertEquals(approvalLightbox.verifyPrivacy(), "Shared");
        Assert.assertTrue(approvalLightbox.verifyCongratulationField());
        Assert.assertEquals(approvalLightbox.verifyApproveButton(), "Approve");
        Assert.assertEquals(approvalLightbox.verifyDisapproveButton(), "Disapprove");
        logger.info("Approve nomination");
        approvalLightbox.approveNomination();
        Thread.sleep(10000);


    }

    public StringBuilder verifyMyApprovalsPage() {
        StringBuilder errorStack = new StringBuilder();
        MyApprovalsPage myApprovalsPage = new MyApprovalsPage(getDriver());
        if(!myApprovalsPage.getApprovalsTitle().equals("My Approvals")) {
            errorStack.append("Unexpected title of My Approvals Page");
        }
        return errorStack;
    }
}
