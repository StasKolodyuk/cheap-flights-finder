package by.kolodyuk.cheapflightsfinder.service;

import by.kolodyuk.cheapflightsfinder.api.Flight;
import by.kolodyuk.cheapflightsfinder.api.FlightCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompositeCheapFlightsService extends AbstractCheapFlightsService {

    @Autowired
    private List<CheapFlightsService> cheapFlightsServices;

    @Override
    public List<Flight> findRawCheapFlights(FlightCriteria criteria) {
        return cheapFlightsServices.stream()
                                   .map(s -> s.findCheapFlights(criteria))
                                   .flatMap(Collection::stream)
                                   .collect(Collectors.toList());
    }

}
