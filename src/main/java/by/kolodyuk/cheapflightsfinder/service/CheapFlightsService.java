package by.kolodyuk.cheapflightsfinder.service;


import by.kolodyuk.cheapflightsfinder.model.FlightRecord;

import java.util.List;

public interface CheapFlightsService {

    List<FlightRecord> findCheapFlights();

}
