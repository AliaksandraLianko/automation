package webservices;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;


public class ApacheHttpClient {
    protected static CloseableHttpClient client;

    @BeforeTest
    public void createClient() {
        client= HttpClients.createDefault();
    }

    @AfterTest
    public void closeClient() throws IOException {
        if (client != null)
            client.close();

    }
}
