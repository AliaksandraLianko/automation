package pages.nomination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class SelectRecipientPage extends BasePage {
    @FindBy(xpath="//*[@id='np-select-recipient-content']/div[2]/ul[3]/li[1]")
    private TextInput recipient;

    @FindBy(xpath="//*[@id='np_sideSection']/div[1]/button")
    private Button nextButton;

    public void selectRecipient() {
        recipient.click();
        waitElementPresent(By.xpath("//*[@id='np_sideSection']/div[1]/button"));
    }

    public void clickNext() throws InterruptedException{
        nextButton.click();
        waitElementPresent(By.xpath("//*[@class='np-award-programs-list']"));
        Thread.sleep(2000);
    }

    public SelectRecipientPage(WebDriver driver) {
        super(driver);
    }
}
