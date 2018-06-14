package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ApprovalLightbox;
import pages.TopMenuPage;
import pages.mydashboard.MyApprovalsPage;
import pages.mydashboard.MyDashboardMenuPage;

public class ApproveNomination extends BaseApproverTest{

    @Test(priority = 1)
    public void approveNomination() throws InterruptedException {
        TopMenuPage topMenuPage = new TopMenuPage(getDriver());
        topMenuPage.goToMyDashboard();
        MyDashboardMenuPage myDashboardMenuPage = new MyDashboardMenuPage(getDriver());
        myDashboardMenuPage.goToMyApprovals();
        MyApprovalsPage myApprovalsPage = new MyApprovalsPage(getDriver());
        Assert.assertEquals(myApprovalsPage.verifyApprovalsTitle(), "My Approvals");
        Assert.assertEquals(myApprovalsPage.verifyNominationTitle(), "Norma Nominator nominated\n" +
                "Mandy Manager1");
        Assert.assertTrue(myApprovalsPage.verifyApprovalCard());
        Assert.assertTrue(myApprovalsPage.verifyAwardValue());
        Assert.assertEquals(myApprovalsPage.verifyAwardTitle(), "Test award title");
        Assert.assertEquals(myApprovalsPage.verifyAwardMessage(), "Test message to recipient");
        Assert.assertEquals(myApprovalsPage.verifyViewNominationLink(), "View Nomination");
        Assert.assertEquals(myApprovalsPage.verifyApproveButton(), "Approve");
        Assert.assertEquals(myApprovalsPage.verifyDisapproveButton(), "Disapprove");
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
        approvalLightbox.approveNomination();
        Thread.sleep(5000);

    }
}