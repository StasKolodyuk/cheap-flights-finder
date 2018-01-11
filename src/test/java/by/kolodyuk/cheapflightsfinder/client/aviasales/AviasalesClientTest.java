package by.kolodyuk.cheapflightsfinder.client.aviasales;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AviasalesClientTest {

    @Autowired
    AviasalesClient aviasalesClient;

    @Test
    public void getFlightsSummary() throws Exception {
        aviasalesClient.getFlightsSummary().forEach(System.out::println);
    }

}