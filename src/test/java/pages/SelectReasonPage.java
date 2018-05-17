package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectReasonPage extends BasePage {

    @FindBy(xpath="//div[@class='clearfix np-award-reasons-list']/div[3]")
    private WebElement reason;

    @FindBy(xpath="//*[@id='np_nominatorAndNominees']/div/div[1]")
    private WebElement selectedProgram;

    public void selectReason() throws InterruptedException {
        reason.click();
        waitElementPresent(By.className("np-program-advisor"));
        Thread.sleep(2000);
    }
    public String getSelectedProgram() {
        return selectedProgram.getText();
    }
    public SelectReasonPage(WebDriver driver) {
        super(driver);
    }
}
