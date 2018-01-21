package by.kolodyuk.cheapflightsfinder.service.ryanair;

import by.kolodyuk.cheapflightsfinder.client.ryanair.RyanairClient;
import by.kolodyuk.cheapflightsfinder.api.Flight;
import by.kolodyuk.cheapflightsfinder.service.CheapFlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RyanairService implements CheapFlightsService {

    @Autowired
    private RyanairClient ryanairClient;

    @Override
    public List<Flight> findCheapFlights() {
        return ryanairClient.getFlightsSummary();
    }
}
