package by.kolodyuk.cheapflightsfinder.controller;

import by.kolodyuk.cheapflightsfinder.api.FlightCriteria;
import by.kolodyuk.cheapflightsfinder.api.FlightExtended;
import by.kolodyuk.cheapflightsfinder.service.CompositeCheapFlightsService;
import by.kolodyuk.cheapflightsfinder.service.aviasales.AviasalesService;
import by.kolodyuk.cheapflightsfinder.service.ryanair.RyanairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/flights/cheap")
public class CheapFlightsController {

    @Autowired
    private CompositeCheapFlightsService compositeCheapFlightsService;
    @Autowired
    private RyanairService ryanairService;
    @Autowired
    private AviasalesService aviasalesService;

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String findCheapFlightsAsString(FlightCriteria criteria) {
        return compositeCheapFlightsService.findCheapFlightsExtendedString(criteria);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<FlightExtended> findCheapFlights(FlightCriteria criteria) {
        return compositeCheapFlightsService.findCheapFlightsExtended(criteria);
    }

    @GetMapping(path = "/ryanair", produces = APPLICATION_JSON_VALUE)
    public List<FlightExtended> findRyanairCheapFlights(FlightCriteria criteria) {
        return ryanairService.findCheapFlightsExtended(criteria);
    }

    @GetMapping(path = "/aviasales", produces = APPLICATION_JSON_VALUE)
    public List<FlightExtended> findAviasalesCheapFlights(FlightCriteria criteria) {
        return aviasalesService.findCheapFlightsExtended(criteria);
    }

}
