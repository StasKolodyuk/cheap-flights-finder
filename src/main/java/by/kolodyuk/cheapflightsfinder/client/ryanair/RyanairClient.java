package by.kolodyuk.cheapflightsfinder.client.ryanair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import by.kolodyuk.cheapflightsfinder.client.ryanair.model.Fare;
import by.kolodyuk.cheapflightsfinder.client.ryanair.model.RyanairFlightSearchResponse;
import by.kolodyuk.cheapflightsfinder.model.Flight;

import static by.kolodyuk.cheapflightsfinder.model.Flight.EUR;

@Component
public class RyanairClient {

    public static String SOURCE = "Ryanair";
    public static String API_URL = "https://api.ryanair.com";
    public static String API_PATH = "/farefinder/3/roundTripFares";

    @Autowired
    private RestTemplate restTemplate;

    public List<Flight> getFlightsSummary() {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(API_URL + API_PATH);
        uriBuilder.queryParam("departureAirportIataCode", "VNO");
        uriBuilder.queryParam("durationFrom", "01");
        uriBuilder.queryParam("durationTo", "03");
        uriBuilder.queryParam("inboundDepartureDateFrom", LocalDate.now());
        uriBuilder.queryParam("inboundDepartureDateTo", LocalDate.now().plusYears(1));
        uriBuilder.queryParam("outboundDepartureDateFrom", LocalDate.now());
        uriBuilder.queryParam("outboundDepartureDateTo", LocalDate.now().plusYears(1));
        uriBuilder.queryParam("priceValueTo", "50");
        uriBuilder.queryParam("language", "en");

        RyanairFlightSearchResponse response = restTemplate.getForObject(uriBuilder.build().encode().toUri(), RyanairFlightSearchResponse.class);

        return response.getFares().stream().map(this::convert).collect(Collectors.toList());
    }

    public Flight convert(Fare fare) {
        Flight flight = new Flight();
        flight.setSource(SOURCE);
        flight.setPrice(fare.getSummary().getPrice().getValue());
        flight.setCurrency(EUR);
        flight.setFromAirportIataCode(fare.getOutbound().getDepartureAirport().getIataCode());
        flight.setToAirportIataCode(fare.getOutbound().getArrivalAirport().getIataCode());
        flight.setFromDate(fare.getOutbound().getDepartureDate().toLocalDate());
        flight.setToDate(fare.getInbound().getArrivalDate().toLocalDate());

        return flight;
    }

}
