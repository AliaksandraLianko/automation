package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.ConfigAppPreconditions;

import java.util.List;

public class ConfigApp extends ConfigAppPreconditions {

    private static final String URL = "https://staging-sandbox0.corp.globoforce.com/iaf-login-app/home";
    private String userName = "bhkb.jshcw@gqfozpkzgb.kbk";
    private String password = "password1";
    @Test
    public void verifyActions() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(URL);
        driver.findElement(By.name("j_username")).sendKeys(userName);
        driver.findElement(By.name("j_password")).sendKeys(password);
        driver.findElement(By.className("button")).click();
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[@class='drop']"))).perform();
        driver.findElement(By.xpath("//a[@href='/iaf-config-app/']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href='/iaf-config-app/siteSettingsOpen?client=5021&menuid=2_1']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//td[@id='ygtvcontentel39']")).click();
        driver.findElement(By.xpath("//a[@id='ygtvlabelel40']")).click();
        Thread.sleep(3000);
        List<WebElement> programs = driver.findElements(By.xpath("//tbody[@class='yui-dt-data']/tr"));
        actions.dragAndDrop(programs.get(1), programs.get(0)).build().perform();
        //actions.clickAndHold(programs.get(1)).moveToElement(programs.get(0)).build().perform();
        Thread.sleep(5000);




    }

}
