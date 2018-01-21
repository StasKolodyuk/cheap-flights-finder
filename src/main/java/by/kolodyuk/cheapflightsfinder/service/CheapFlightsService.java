package by.kolodyuk.cheapflightsfinder.service;


import by.kolodyuk.cheapflightsfinder.api.Flight;
import by.kolodyuk.cheapflightsfinder.api.FlightCriteria;

import java.util.List;

public interface CheapFlightsService {

    List<Flight> findCheapFlights(FlightCriteria criteria);

    default List<Flight> findCheapFlights() {
        return findCheapFlights(new FlightCriteria());
    }

}
