package by.kolodyuk.cheapflightsfinder.service;


import by.kolodyuk.cheapflightsfinder.model.Flight;
import by.kolodyuk.cheapflightsfinder.model.FlightExtended;

import java.util.List;

public interface CheapFlightsService {

    List<Flight> findCheapFlights();

}
