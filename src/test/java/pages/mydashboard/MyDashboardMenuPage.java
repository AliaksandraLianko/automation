package pages.mydashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.element.Link;

public class MyDashboardMenuPage extends BasePage {
    private By nominationsTitle = By.className("nominations-title");
    private By approvalsTitle = By.className("approvals-section-header-text");

    @FindBy(xpath="//*//a[contains(@href,'MyNominations')]")
    private Link myNominations;

    @FindBy(xpath="//*//a[contains(@href,'MyApprovals')]")
    private Link myApprovals;

    public void goToMyNominations(){
        myNominations.click();
        waitElementPresent(nominationsTitle);
    }

    public void goToMyApprovals(){
        myApprovals.click();
        waitElementPresent(approvalsTitle);
    }

    public MyDashboardMenuPage(WebDriver driver) {
        super(driver);
    }
}
