package by.kolodyuk.cheapflightsfinder.service;

import by.kolodyuk.cheapflightsfinder.model.FlightRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompositeCheapFlightsService implements CheapFlightsService {

    @Autowired
    private List<CheapFlightsService> cheapFlightsServices;

    @Override
    public List<FlightRecord> findCheapFlights() {
        return cheapFlightsServices.stream()
                                   .map(CheapFlightsService::findCheapFlights)
                                   .flatMap(Collection::stream)
                     .sorted(FlightRecord.PRICE_COMPARATOR).collect(Collectors.toList());
    }
}
