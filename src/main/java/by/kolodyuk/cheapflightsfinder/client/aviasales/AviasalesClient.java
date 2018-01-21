package by.kolodyuk.cheapflightsfinder.client.aviasales;

import by.kolodyuk.cheapflightsfinder.client.aviasales.model.AviasalesFightSearchResponse;
import by.kolodyuk.cheapflightsfinder.api.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

import static by.kolodyuk.cheapflightsfinder.api.Flight.EUR;

@Component
public class AviasalesClient {

    public static String SOURCE = "Aviasales";
    public static String API_URL = "http://api.travelpayouts.com";
    public static String API_PATH = "/v2/prices/latest";

    @Autowired
    private RestTemplate restTemplate;

    public List<Flight> getFlightsSummary() {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(API_URL + API_PATH);
        uriBuilder.queryParam("origin", "VNO");
        uriBuilder.queryParam("trip_duration", 0);
        uriBuilder.queryParam("currency", "EUR");
        uriBuilder.queryParam("sorting", "price");
        uriBuilder.queryParam("trip_class", 0);
        uriBuilder.queryParam("show_to_affiliates", false);
        uriBuilder.queryParam("period_type", "year");
        uriBuilder.queryParam("limit", 100);
        uriBuilder.queryParam("token", "67122f849a425e3fea155eb50cdaf923");

        AviasalesFightSearchResponse response = restTemplate.getForObject(uriBuilder.build().encode().toUri(), AviasalesFightSearchResponse.class);

        return response.getData().stream().map(this::convert).collect(Collectors.toList());
    }

    private Flight convert(by.kolodyuk.cheapflightsfinder.client.aviasales.model.Flight flight) {
        Flight flightRecord = new Flight();
        flightRecord.setSource(SOURCE);
        flightRecord.setPrice(flight.getPrice());
        flightRecord.setCurrency(EUR);
        flightRecord.setFromAirportIataCode(flight.getOrigin());
        flightRecord.setToAirportIataCode(flight.getDestination());
        flightRecord.setFromDate(flight.getDepartDate());
        flightRecord.setToDate(flight.getReturnDate());

        return flightRecord;
    }

}
