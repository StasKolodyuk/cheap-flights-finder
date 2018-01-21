package by.kolodyuk.cheapflightsfinder.service.aviasales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import by.kolodyuk.cheapflightsfinder.client.aviasales.AviasalesClient;
import by.kolodyuk.cheapflightsfinder.api.Flight;
import by.kolodyuk.cheapflightsfinder.service.CheapFlightsService;

@Service
public class AviasalesService implements CheapFlightsService {

    @Autowired
    private AviasalesClient aviasalesClient;

    @Override
    public List<Flight> findCheapFlights() {
        return aviasalesClient.getFlightsSummary();
    }
}
