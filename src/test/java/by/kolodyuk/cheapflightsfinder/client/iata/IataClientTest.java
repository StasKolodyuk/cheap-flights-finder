package by.kolodyuk.cheapflightsfinder.client.iata;

import by.kolodyuk.cheapflightsfinder.client.ClientsConfig;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = ClientsConfig.class)
@RunWith(SpringRunner.class)
public class IataClientTest {

    @Autowired
    IataClient iataClient;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getAirportInfo() throws Exception {
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(iataClient.getAirportInfo("LTN")));
    }

}
