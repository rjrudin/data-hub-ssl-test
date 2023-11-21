package org.example;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.ext.modulesloader.ssl.SimpleX509TrustManager;

public class JavaClientTest {
    public static void main(String[] args) {
        DatabaseClient client = DatabaseClientFactory.newClient("localhost", 8010,
                new DatabaseClientFactory.DigestAuthContext("admin", "admin")
                        .withSSLHostnameVerifier(DatabaseClientFactory.SSLHostnameVerifier.ANY)
                        .withSSLContext(
                                // This defaults to using TLSv1.2
                                SimpleX509TrustManager.newSSLContext(),
                                new SimpleX509TrustManager()
                        ));

        DatabaseClient.ConnectionResult result = client.checkConnection();
        System.out.println(result.getStatusCode() + ":" + result.getErrorMessage());
    }
}