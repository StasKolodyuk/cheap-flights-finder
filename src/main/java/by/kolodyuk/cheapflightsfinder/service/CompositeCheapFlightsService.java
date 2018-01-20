package by.kolodyuk.cheapflightsfinder.service;

import by.kolodyuk.cheapflightsfinder.client.iata.IataClient;
import by.kolodyuk.cheapflightsfinder.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompositeCheapFlightsService extends AbstractCheapFlightsService {

    public static final Double MAX_PRICE_EUR = 50.0;

    @Autowired
    private List<CheapFlightsService> cheapFlightsServices;
    @Autowired
    IataClient iataClient;

    @Override
    public List<Flight> findCheapFlights() {
        return cheapFlightsServices.stream()
                                   .map(CheapFlightsService::findCheapFlights)
                                   .flatMap(Collection::stream)
                                   .sorted(Flight.PRICE_COMPARATOR)
                                   .filter(f -> f.getPrice() < MAX_PRICE_EUR)
                                   .collect(Collectors.toList());
    }

}
