package webservices.scenarios;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import webservices.client.HttpClient;
import java.io.IOException;
import java.util.Map;

public class NegativeErrorCode {
    private static final String URL = "http://services.groupkt.com/css/app.css";
    private Logger logger = Logger.getLogger(getClass());

    @Test
    public void negativeScenario() throws IOException {
        HttpClient client = new HttpClient();
        Map<String, Object> result = client.doGetRequest(URL);
        logger.info("Status code verification");
        Assert.assertEquals(result.get("code"), 404, "Unexpected status code!");
        logger.info("Response verification");
        String expectedResponse = "HTTP Status 404 – Not Found";
        Assert.assertTrue(result.get("content").toString().contains(expectedResponse), "Wrong response!");
    }
}
