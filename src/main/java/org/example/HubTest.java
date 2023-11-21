package org.example;

import com.marklogic.client.DatabaseClient;
import com.marklogic.hub.HubConfig;
import com.marklogic.hub.impl.HubConfigImpl;

import java.io.FileReader;
import java.util.Properties;

public class HubTest {

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        try (FileReader reader = new FileReader("gradle.properties")) {
            props.load(reader);
        }

        HubConfig hubConfig = HubConfigImpl.withProperties(props);
        DatabaseClient client = hubConfig.newStagingClient();
        DatabaseClient.ConnectionResult result = client.checkConnection();
        System.out.println(result.getStatusCode() + ":" + result.getErrorMessage());
    }
}
