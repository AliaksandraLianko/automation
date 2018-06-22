package webservices.scenarios;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import webservices.client.HttpClient;

import java.io.IOException;
import java.util.Map;

public class NegativeScenario {
    private static final String URL = "http://services.groupkt.com/state/get/%s/%s";
    private String country = "USA";
    private String state = "test";
    private Logger logger = Logger.getLogger(getClass());

    @Test
    public void negativeScenario() throws IOException {
        String resultURL = String.format(URL, country, state);
        HttpClient client = new HttpClient();
        Map<String, Object> result = client.doGetRequest(resultURL);
        logger.info("Status code verification");
        Assert.assertEquals(result.get("code"), 200, "Unexpected status code!");
        String errorMessage = String.format("No matching state found for requested code [%s->%s].", country, state);
        logger.info("Error message verification");
        Assert.assertTrue(result.get("content").toString().contains(errorMessage), "Wrong error message!");
    }
}
