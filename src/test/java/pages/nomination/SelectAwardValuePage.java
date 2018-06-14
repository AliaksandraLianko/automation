package pages.nomination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class SelectAwardValuePage extends BasePage {

    @FindBy(xpath="//*[@class='clearfix np-award-values-list']/div[2]")
    private TextBlock award2;

    public void selectAwardLevel() throws InterruptedException {
        award2.click();
        waitElementPresent(By.id("np_awardTitle"));
        Thread.sleep(2000);
    }

    public SelectAwardValuePage(WebDriver driver) {
        super(driver);
    }
}
