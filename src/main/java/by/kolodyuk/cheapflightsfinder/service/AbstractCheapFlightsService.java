package by.kolodyuk.cheapflightsfinder.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import by.kolodyuk.cheapflightsfinder.client.iata.IataClient;
import by.kolodyuk.cheapflightsfinder.client.iata.model.Airport;
import by.kolodyuk.cheapflightsfinder.model.Flight;
import by.kolodyuk.cheapflightsfinder.model.FlightExtended;

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

        Airport fromAirport = iataClient.getAirportInfo();


        Airport toAirport = iataClient.getAirportInfo();




        flightExtended.setFromAirport();
    }

    private String fromAirport;
    private String fromCity;
    private String fromCountry;

    private String toAirport;
    private String toCity;
    private String toCountry;


}
