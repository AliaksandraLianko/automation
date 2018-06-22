package scenarios;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RemoteDriverHelper;


public class RemoteDriver extends RemoteDriverHelper {
    private Logger logger = Logger.getLogger(getClass());

    @Test
    public void test(){
        logger.info("Open Globoforce site");
        driver.get("https://www.globoforce.com/");
        logger.info("Verify title on Globoforce site");
        Assert.assertEquals(driver.getTitle(), "Globoforce | Elevate Workplace Culture and Performance | Globoforce");
    }
}
