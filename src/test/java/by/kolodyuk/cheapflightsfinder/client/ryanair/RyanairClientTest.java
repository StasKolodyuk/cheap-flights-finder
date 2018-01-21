package by.kolodyuk.cheapflightsfinder.client.ryanair;

import by.kolodyuk.cheapflightsfinder.client.ClientsConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClientsConfig.class)
public class RyanairClientTest {

    @Autowired
    RyanairClient ryanairClient;

    @Test
    public void getFlightsSummary() throws Exception {
        ryanairClient.getFlightsSummary().forEach(System.out::println);
    }

}