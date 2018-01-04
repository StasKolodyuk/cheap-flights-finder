package by.kolodyuk.cheapflightsfinder.client.ryanair;

import by.kolodyuk.cheapflightsfinder.client.ryanair.model.Fare;
import by.kolodyuk.cheapflightsfinder.client.ryanair.model.RyanairFlightSearchResponse;
import by.kolodyuk.cheapflightsfinder.model.FlightRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RyanairClient {

    public static String API_URL = "https://api.ryanair.com";
    public static String CHEAP_ROUND_TRIPS_PATH = "/farefinder/3/roundTripFares";

    @Autowired
    private RestTemplate restTemplate;

    public List<FlightRecord> getFlightsSummary() {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(API_URL + CHEAP_ROUND_TRIPS_PATH);
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

    public FlightRecord convert(Fare fare) {
        FlightRecord flightRecord = new FlightRecord();
        flightRecord.setPrice(fare.getSummary().getPrice().getValue() + fare.getSummary().getPrice().getCurrencySymbol());
        flightRecord.setFromCity(fare.getOutbound().getDepartureAirport().getName());
        flightRecord.setToCity(fare.getOutbound().getArrivalAirport().getName());
        flightRecord.setFromDate(fare.getOutbound().getDepartureDate().format(DateTimeFormatter.ofPattern("MMM dd")));
        flightRecord.setToDate(fare.getInbound().getArrivalDate().format(DateTimeFormatter.ofPattern("MMM dd")));

        return flightRecord;
    }

}
