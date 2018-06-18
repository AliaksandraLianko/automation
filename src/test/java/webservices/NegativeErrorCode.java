package webservices;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NegativeErrorCode extends ApacheHttpClient {
    private static final String URL = "http://services.groupkt.com/css/app.css";

    @Test
    public void negativeScenario() throws IOException {
        HttpGet httpPost = new HttpGet(URL);
        CloseableHttpResponse response = client.execute(httpPost);
        System.out.println("Response status code is " + response.getStatusLine().getStatusCode());
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 404);

        BufferedReader rd = new BufferedReader((new InputStreamReader(response.getEntity().getContent())));
        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        System.out.println(result);

    }
}
