package by.kolodyuk.cheapflightsfinder.controller;

import by.kolodyuk.cheapflightsfinder.api.FlightExtended;
import by.kolodyuk.cheapflightsfinder.printer.FlightPrinter;
import by.kolodyuk.cheapflightsfinder.service.CompositeCheapFlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/flights/cheap")
public class CheapFlightsController {

    @Autowired
    private FlightPrinter flightPrinter;
    @Autowired
    private CompositeCheapFlightsService compositeCheapFlightsService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<FlightExtended> findCheapFlights() {
        return compositeCheapFlightsService.findCheapFlightsExtended();
    }

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String findCheapFlightsAsString() {
        return compositeCheapFlightsService.findCheapFlightsExtended()
                                           .stream()
                                           .map(flightPrinter::toString)
                                           .collect(Collectors.joining("\n"));
    }

}
