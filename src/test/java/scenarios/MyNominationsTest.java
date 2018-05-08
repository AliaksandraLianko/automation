package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Preconditions;


public class MyNominationsTest extends Preconditions {

    @Test
    public void verifyMyNominationsPage() throws InterruptedException{
        driver.navigate().to("https://test-web1-17.corp.globoforce.com/microsites/t/home?client=recipientbased&setCAG=true");
        waitElementPresent(By.name("username"));
        driver.findElement(By.name("username")).sendKeys("norma_nominator");
        driver.findElement(By.name("password")).sendKeys("pass");
        driver.findElement(By.id("signIn-button")).click();
        waitElementPresent(By.xpath("//*[@id=\"navBar\"]//a[contains(@href,'dashboard')]"));
        driver.findElement(By.xpath("//*[@id=\"navBar\"]//a[contains(@href,'dashboard')]")).click();
        waitElementPresent(By.xpath("//*//a[contains(@href,'MyNominations')]"));
        driver.findElement(By.xpath("//*//a[contains(@href,'MyNominations')]")).click();
        waitElementPresent(By.className("nominations-title"));
        Assert.assertEquals(driver.findElement(By.className("nominations-title")).getText(),"People You Have Recognized");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='a-table a-table-nominations']/thead/tr/th[1]")).getText(),"Date");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='a-table a-table-nominations']/thead/tr/th[2]")).getText(),"Award Type");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='a-table a-table-nominations']/thead/tr/th[3]")).getText(),"Recipient");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='a-table a-table-nominations']/thead/tr/th[4]")).getText(),"Status");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='a-table a-table-nominations']/thead/tr/th[5]")).getText(),"Award Amount");
        driver.findElement(By.xpath("//*[@class='detailsLink a-tooltip-target']")).click();
        driver.findElement(By.xpath("//*[@id='panel']/div/div/div/h1")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div/h1")).getText(),"Nomination Details");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div[2]/table[1]/tbody/tr[1]/th[1]")).getText(),"Date Nominated");
        //Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div[2]/table[1]/tbody/tr[1]/td[1]")).getText(),"Date");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div[2]/table[1]/tbody/tr[2]/th[1]")).getText(),"Award Type");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div[2]/table[1]/tbody/tr[2]/td[1]")).getText(),"Award2");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div[2]/table[1]/tbody/tr[3]/th[1]")).getText(),"Award Reason");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div[2]/table[1]/tbody/tr[3]/td[1]")).getText(),"REASON3");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div[2]/table[1]/tbody/tr[4]/th[1]")).getText(),"Department");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div[2]/table[1]/tbody/tr[4]/td[1]")).getText(),"Office of the CEO");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div[2]/table[1]/tbody/tr[5]/th[1]")).getText(),"Award Title");
        //Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div[2]/table[1]/tbody/tr[5]/td[1]")).getText(),"Test Award Title");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div[2]/table[1]/tbody/tr[1]/th[2]")).getText(),"Nominator");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div[2]/table[1]/tbody/tr[1]/td[2]")).getText(),"Norma Nominator");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div[2]/table[1]/tbody/tr[2]/th[2]")).getText(),"Current Approver");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div[2]/table[1]/tbody/tr[2]/td[2]")).getText(),"Manfred Manager2");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div[2]/table[1]/tbody/tr[3]/th[2]")).getText(),"Status");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div[2]/table[1]/tbody/tr[3]/td[2]")).getText(),"Pending");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div[2]/table[1]/tbody/tr[4]/th[2]")).getText(),"Submitted By");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div[2]/table[1]/tbody/tr[4]/td[2]")).getText(),"Norma Nominator");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div[2]/table[1]/tbody/tr[5]/th[2]")).getText(),"Privacy Level");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div[2]/table[1]/tbody/tr[5]/td[2]")).getText(),"Shared\n" +
                "Shared - display on Company Awards Feed");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div[2]/table[2]/tbody/tr[1]/th")).getText(),"Message to Approving Manager");
        //Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div[2]/table[2]/tbody/tr[1]/td")).getText(),"Test message to approver");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div[2]/table[2]/tbody/tr[2]/th")).getText(),"Message to Recipient");
        //Assert.assertEquals(driver.findElement(By.xpath("//*[@id='panel']/div/div/div[2]/table[2]/tbody/tr[2]/td")).getText(),"Test message to recipient");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='recipientsTab']/a")).getText(),"RECIPIENTS");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='approversTab']/a")).getText(),"APPROVERS");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='historyTab']/a")).getText(),"HISTORY");











    }


}
