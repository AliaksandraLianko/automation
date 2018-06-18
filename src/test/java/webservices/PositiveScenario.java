package webservices;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PositiveScenario extends ApacheHttpClient {
    private static final String URL = "http://services.groupkt.com/state/get/USA/AZ";

    @Test
    public void positiveScenario() throws IOException {
        HttpGet httpPost = new HttpGet(URL);
        CloseableHttpResponse response = client.execute(httpPost);
        System.out.println("Response status code is " + response.getStatusLine().getStatusCode());
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);

        BufferedReader rd = new BufferedReader((new InputStreamReader(response.getEntity().getContent())));
        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        System.out.println(result);
        Assert.assertEquals(result.toString(), "{  \"RestResponse\" : {    \"messages\" : [ \"State found matching code [AZ].\" ],    \"result\" : {      \"id\" : 3,      \"country\" : \"USA\",      \"name\" : \"Arizona\",      \"abbr\" : \"AZ\",      \"area\" : \"113594SKM\",      \"largest_city\" : \"Phoenix\",      \"capital\" : \"Phoenix\"    }  }}");
    }

}
