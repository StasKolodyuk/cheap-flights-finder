package by.kolodyuk.cheapflightsfinder.service.ryanair;

import by.kolodyuk.cheapflightsfinder.api.Flight;
import by.kolodyuk.cheapflightsfinder.api.FlightCriteria;
import by.kolodyuk.cheapflightsfinder.client.ryanair.RyanairClient;
import by.kolodyuk.cheapflightsfinder.service.AbstractCheapFlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RyanairService extends AbstractCheapFlightsService {

    @Autowired
    private RyanairClient ryanairClient;

    @Override
    public List<Flight> findRawCheapFlights(FlightCriteria criteria) {
        return criteria.getStartingPointIataCodes()
                .stream()
                .map(code -> ryanairClient.getFlightsSummary(code, criteria.getDurationFromDays(), criteria.getDurationToDays(), criteria.getMaxPrice()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
