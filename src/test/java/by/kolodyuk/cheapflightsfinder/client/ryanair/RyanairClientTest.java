package by.kolodyuk.cheapflightsfinder.client.ryanair;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RyanairClientTest {

    @Autowired
    RyanairClient ryanairClient;

    @Test
    public void getFlightsSummary() throws Exception {
        ryanairClient.getFlightsSummary().forEach(System.out::println);
    }

}