package by.kolodyuk.cheapflightsfinder.service;

import by.kolodyuk.cheapflightsfinder.client.iata.IataClient;
import by.kolodyuk.cheapflightsfinder.client.iata.model.Airport;
import by.kolodyuk.cheapflightsfinder.model.Flight;
import by.kolodyuk.cheapflightsfinder.model.FlightExtended;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

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

        Airport fromAirport = iataClient.getAirportInfo(flight.getFromAirportIataCode());
        flightExtended.setFromAirport(fromAirport.getName());
        flightExtended.setFromCity(getCity(fromAirport));
        flightExtended.setFromCountry(getCountry(fromAirport));

        Airport toAirport = iataClient.getAirportInfo(flight.getToAirportIataCode());
        flightExtended.setToAirport(toAirport.getName());
        flightExtended.setToCity(getCity(toAirport));
        flightExtended.setToCountry(getCountry(toAirport));

        return flightExtended;
    }

    private static String getCity(Airport airport) {
        return StringUtils.substringBefore(airport.getLocation(), ",");
    }

    private static String getCountry(Airport airport) {
        return StringUtils.substringAfter(airport.getLocation(), ",");
    }

}
