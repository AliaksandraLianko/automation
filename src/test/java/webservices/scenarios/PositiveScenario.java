package webservices.scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import webservices.client.HttpClient;

import java.io.IOException;
import java.util.Map;

public class PositiveScenario {
    private static final String URL = "http://services.groupkt.com/state/get/%s/%s";
    private String country = "USA";
    private String state = "AZ";

    @Test
    public void positiveScenario() throws IOException {
        String resultURL = String.format(URL, country, state);
        HttpClient client = new HttpClient();
        Map<String, Object> result = client.doGetRequest(resultURL);
        Assert.assertEquals(result.get("code"), 200, "Unexpected status code!");
        String expectedCountry = String.format("\"country\" : \"%s\"", country);
        Assert.assertTrue(result.get("content").toString().contains(expectedCountry), "Wrong country!");
        String expectedState = String.format("\"name\" : \"%s\"", "Arizona");
        Assert.assertTrue(result.get("content").toString().contains(expectedState), "Wrong state name!");
        String expectedAbbr = String.format("\"abbr\" : \"%s\"", "AZ");
        Assert.assertTrue(result.get("content").toString().contains(expectedAbbr), "Wrong state abbr!");
        String expectedArea = String.format("\"area\" : \"%s\"", "113594SKM");
        Assert.assertTrue(result.get("content").toString().contains(expectedArea), "Wrong state area!");
        String expectedLargestCity = String.format("\"largest_city\" : \"%s\"", "Phoenix");
        Assert.assertTrue(result.get("content").toString().contains(expectedLargestCity), "Wrong largest city!");
        String expectedCapital = String.format("\"capital\" : \"%s\"", "Phoenix");
        Assert.assertTrue(result.get("content").toString().contains(expectedCapital), "Wrong capital!");

    }

}
