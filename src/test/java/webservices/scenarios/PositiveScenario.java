package webservices.scenarios;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.CustomListener;
import webservices.client.HttpClient;

import java.io.IOException;
import java.util.Map;

@Listeners(CustomListener.class)
public class PositiveScenario {
    private static final String URL = "http://services.groupkt.com/state/get/%s/%s";
    private String country = "USA";
    private String state = "AZ";
    private Map<String, Object> result;
    private Logger logger = Logger.getLogger(getClass());
    //CustomListener customListener = new CustomListener();

    @BeforeClass
    public void getResponse() throws IOException {
        String resultURL = String.format(URL, country, state);
        HttpClient client = new HttpClient();
        result = client.doGetRequest(resultURL);
    }

    @Test
    public void verifyStatusCode() {
        logger.info("Status code verification");
        Assert.assertEquals(result.get("code"), 200, "Unexpected status code!");
    }

    @Test(dependsOnMethods = "verifyStatusCode")
    public void verifyCountry() {
        logger.info("Country verification");
        String expectedCountry = String.format("\"country\" : \"%s\"", country);
        Assert.assertTrue(result.get("content").toString().contains(expectedCountry), "Wrong country!");
    }

    @Test(dependsOnMethods = "verifyCountry")
    public void verifyStateName() {
        logger.info("State verification");
        String expectedState = String.format("\"name\" : \"%s\"", "Arizona");
        Assert.assertTrue(result.get("content").toString().contains(expectedState), "Wrong state name!");
    }

    @Test(dependsOnMethods = "verifyStateName")
    public void verifyAbbr() {
        logger.info("Abbreviation verification");
        String expectedAbbr = String.format("\"abbr\" : \"%s\"", "AZ");
        Assert.assertTrue(result.get("content").toString().contains(expectedAbbr), "Wrong state abbr!");
    }

    @Test(dependsOnMethods = "verifyAbbr")
    public void verifyArea() {
        logger.info("Area verification");
        String expectedArea = String.format("\"area\" : \"%s\"", "113594SKM");
        Assert.assertTrue(result.get("content").toString().contains(expectedArea), "Wrong state area!");
    }

    @Test(dependsOnMethods = "verifyArea")
    public void verifyLargestCity() {
        logger.info("Largest city verification");
        String expectedLargestCity = String.format("\"largest_city\" : \"%s\"", "Phoenix");
        Assert.assertTrue(result.get("content").toString().contains(expectedLargestCity), "Wrong largest city!");
    }

    @Test(dependsOnMethods = "verifyLargestCity")
    public void verifyCapital() {
        logger.info("Capital verification");
        String expectedCapital = String.format("\"capital\" : \"%s\"", "Phoenix");
        Assert.assertTrue(result.get("content").toString().contains(expectedCapital), "Wrong capital!");
    }

}
