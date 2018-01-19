package by.kolodyuk.cheapflightsfinder.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import by.kolodyuk.cheapflightsfinder.model.Flight;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CompositeCheapFlightsServiceTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    CompositeCheapFlightsService cheapFlightsService;

    @Test
    public void findCheapFlights() throws Exception {
        List<Flight> flights = cheapFlightsService.findCheapFlights();

        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(flights));
    }

}