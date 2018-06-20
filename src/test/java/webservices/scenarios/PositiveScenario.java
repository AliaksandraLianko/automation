package webservices.scenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webservices.client.HttpClient;

import java.io.IOException;
import java.util.Map;

public class PositiveScenario {
    private static final String URL = "http://services.groupkt.com/state/get/%s/%s";
    private String country = "USA";
    private String state = "AZ";
    private Map<String, Object> result;

    @BeforeClass
    public void getResponse() throws IOException {
        String resultURL = String.format(URL, country, state);
        HttpClient client = new HttpClient();
        result = client.doGetRequest(resultURL);
    }

    @Test
    public void verifyStatusCode() {
        Assert.assertEquals(result.get("code"), 200, "Unexpected status code!");
    }

    @Test(dependsOnMethods = "verifyStateCode")
    public void verifyCountry() {
        String expectedCountry = String.format("\"country\" : \"%s\"", country);
        Assert.assertTrue(result.get("content").toString().contains(expectedCountry), "Wrong country!");
    }

    @Test(dependsOnMethods = "verifyCountry")
    public void verifyStateName() {
        String expectedState = String.format("\"name\" : \"%s\"", "Arizona");
        Assert.assertTrue(result.get("content").toString().contains(expectedState), "Wrong state name!");
    }

    @Test(dependsOnMethods = "verifyStateName")
    public void verifyAbbr() {
        String expectedAbbr = String.format("\"abbr\" : \"%s\"", "AZ");
        Assert.assertTrue(result.get("content").toString().contains(expectedAbbr), "Wrong state abbr!");
    }

    @Test(dependsOnMethods = "verifyAbbr")
    public void verifyArea() {
        String expectedArea = String.format("\"area\" : \"%s\"", "113594SKM");
        Assert.assertTrue(result.get("content").toString().contains(expectedArea), "Wrong state area!");
    }

    @Test(dependsOnMethods = "verifyArea")
    public void verifyLargestCity() {
        String expectedLargestCity = String.format("\"largest_city\" : \"%s\"", "Phoenix");
        Assert.assertTrue(result.get("content").toString().contains(expectedLargestCity), "Wrong largest city!");
    }

    @Test(dependsOnMethods = "verifyLargestCity")
    public void verifyCapital() {
        String expectedCapital = String.format("\"capital\" : \"%s\"", "Phoenix");
        Assert.assertTrue(result.get("content").toString().contains(expectedCapital), "Wrong capital!");
    }

}
