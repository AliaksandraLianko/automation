package scenarios;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ConfigAppPreconditions;
import utils.CustomListener;

import java.util.List;

@Listeners(CustomListener.class)
public class ConfigApp extends ConfigAppPreconditions {

    private static final String URL = "https://staging-sandbox0.corp.globoforce.com/iaf-login-app/home";
    private String userName = "bhkb.jshcw@gqfozpkzgb.kbk";
    private String password = "password1";
    private Logger logger = Logger.getLogger(getClass());
    @Test
    public void verifyActions() throws InterruptedException {
        driver.manage().window().maximize();
        logger.info("Open Config App");
        driver.get(URL);
        logger.info("Enter username");
        driver.findElement(By.name("j_username")).sendKeys(userName);
        logger.info("Enter password");
        driver.findElement(By.name("j_password")).sendKeys(password);
        logger.info("Click on log in button");
        driver.findElement(By.className("button")).click();
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        logger.info("Select config app");
        actions.moveToElement(driver.findElement(By.xpath("//a[@class='drop']"))).perform();
        driver.findElement(By.xpath("//a[@href='/iaf-config-app/']")).click();
        Thread.sleep(3000);
        logger.info("Select client");
        driver.findElement(By.xpath("//a[@href='/iaf-config-app/siteSettingsOpen?client=5021&menuid=2_1']")).click();
        Thread.sleep(3000);
        logger.info("Open Awards");
        driver.findElement(By.xpath("//td[@id='ygtvcontentel39']")).click();
        logger.info("Open Award Programs");
        driver.findElement(By.xpath("//a[@id='ygtvlabelel40']")).click();
        Thread.sleep(3000);
        List<WebElement> programs = driver.findElements(By.xpath("//tbody[@class='yui-dt-data']/tr"));
        logger.info("Drag and drop award programs");
        actions.dragAndDrop(programs.get(1), programs.get(0)).build().perform();
        Thread.sleep(5000);




    }

}
