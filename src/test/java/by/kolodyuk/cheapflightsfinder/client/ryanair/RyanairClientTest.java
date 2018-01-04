package by.kolodyuk.cheapflightsfinder.client.ryanair;

import by.kolodyuk.cheapflightsfinder.model.FlightRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RyanairClientTest {

    @Autowired
    RyanairClient ryanairClient;

    @Test
    public void getFlightsSummary() throws Exception {
        List<FlightRecord> flightRecords = ryanairClient.getFlightsSummary();

        System.out.println(flightRecords);
    }

}