package by.kolodyuk.cheapflightsfinder.service.aviasales;

import by.kolodyuk.cheapflightsfinder.api.Flight;
import by.kolodyuk.cheapflightsfinder.api.FlightCriteria;
import by.kolodyuk.cheapflightsfinder.client.aviasales.AviasalesClient;
import by.kolodyuk.cheapflightsfinder.service.AbstractCheapFlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AviasalesService extends AbstractCheapFlightsService {

    @Autowired
    private AviasalesClient aviasalesClient;

    @Override
    public List<Flight> findRawCheapFlights(FlightCriteria criteria) {
        return criteria.getStartingPointIataCodes()
                       .stream()
                       .map(code -> aviasalesClient.getFlightsSummary(code))
                       .flatMap(Collection::stream)
                       .collect(Collectors.toList());
    }

}
