package by.kolodyuk.cheapflightsfinder.service;

import by.kolodyuk.cheapflightsfinder.client.iata.IataClient;
import by.kolodyuk.cheapflightsfinder.client.iata.model.IataResponse;
import by.kolodyuk.cheapflightsfinder.api.Flight;
import by.kolodyuk.cheapflightsfinder.api.FlightExtended;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

public abstract class AbstractCheapFlightsService implements CheapFlightsService {

    @Autowired
    private IataClient iataClient;

    public List<FlightExtended> findCheapFlightsExtended() {
        return findCheapFlights().stream().map(this::convert).collect(Collectors.toList());
    }

    private FlightExtended convert(Flight flight) {
        FlightExtended flightExtended = new FlightExtended();

        flightExtended.setPrice(flight.getPrice());
        flightExtended.setCurrency(flight.getCurrency());
        flightExtended.setSource(flight.getSource());
        flightExtended.setFromAirportIataCode(flight.getFromAirportIataCode());
        flightExtended.setFromDate(flight.getFromDate());
        flightExtended.setToAirportIataCode(flight.getToAirportIataCode());
        flightExtended.setToDate(flight.getToDate());

        IataResponse fromIataResponse = iataClient.getAirportInfo(flight.getFromAirportIataCode());
        if (isNotEmpty(fromIataResponse.getAirports())) {
            flightExtended.setFromAirport(fromIataResponse.getAirports().get(0).getName());
            flightExtended.setFromCity(fromIataResponse.getAirports().get(0).getCity());
            flightExtended.setFromCountry(fromIataResponse.getAirports().get(0).getCountry());
        }

        IataResponse toIataResponse = iataClient.getAirportInfo(flight.getToAirportIataCode());
        if (isNotEmpty(toIataResponse.getAirports())) {
            flightExtended.setToAirport(toIataResponse.getAirports().get(0).getName());
            flightExtended.setToCity(toIataResponse.getAirports().get(0).getCity());
            flightExtended.setToCountry(toIataResponse.getAirports().get(0).getCountry());
        }

        return flightExtended;
    }

}
