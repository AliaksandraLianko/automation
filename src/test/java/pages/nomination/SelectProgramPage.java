package pages.nomination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class SelectProgramPage extends BasePage {

    @FindBy(xpath="//*[@class='np-award-programs-list']/div[1]//h3")
    private TextBlock program;

    @FindBy(xpath="//*[@id='np_nominatorAndNomineesAwardProgram']/div/div[2]")
    private TextBlock info;

    public void selectProgram() throws InterruptedException{
        program.click();
        waitElementPresent(By.xpath("//div[@class='clearfix np-award-reasons-list']"));
        Thread.sleep(2000);
    }

    public String getInfoText() {
        return info.getText();
    }

    public SelectProgramPage(WebDriver driver) {
        super(driver);
    }
}
