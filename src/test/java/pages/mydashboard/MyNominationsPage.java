package pages.mydashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class MyNominationsPage extends BasePage {
    @FindBy(className="nominations-title")
    private TextBlock title;

    @FindBy(xpath="//*[@class='a-table a-table-nominations']/thead/tr/th[1]")
    private TextBlock date;

    @FindBy(xpath="//*[@class='a-table a-table-nominations']/thead/tr/th[2]")
    private TextBlock awardType;

    @FindBy(xpath="//*[@class='a-table a-table-nominations']/thead/tr/th[3]")
    private TextBlock recipient;

    @FindBy(xpath="//*[@class='a-table a-table-nominations']/thead/tr/th[4]")
    private TextBlock status;

    @FindBy(xpath="//*[@class='a-table a-table-nominations']/thead/tr/th[5]")
    private TextBlock awardAmount;

    @FindBy(xpath="//*[@class='detailsLink a-tooltip-target']")
    private TextBlock nominationDetailsIcon;

    public String verifyDate() {
        return date.getText();
    }

    public String verifyAwardType() {
       return awardType.getText();
    }

    public String verifyRecipient() {
        return recipient.getText();
    }

    public String verifyStatus() {
        return status.getText();
    }

    public String verifyAwardAmount() {
        return awardAmount.getText();
    }

    public void openNominationDetailsLightbox(){
        nominationDetailsIcon.click();
        waitElementPresent(By.xpath("//*[@id='panel']/div/div/div/h1"));
    }

    public MyNominationsPage(WebDriver driver) {
        super(driver);
    }

}
