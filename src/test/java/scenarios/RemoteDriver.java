package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RemoteDriverHelper;


public class RemoteDriver extends RemoteDriverHelper {

    @Test
    public void test(){
        driver.get("https://www.globoforce.com/");
        Assert.assertEquals(driver.getTitle(), "Globoforce | Elevate Workplace Culture and Performance | Globoforce");
    }
}
