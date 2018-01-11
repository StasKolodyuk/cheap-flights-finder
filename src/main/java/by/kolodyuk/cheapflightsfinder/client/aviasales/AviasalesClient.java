package by.kolodyuk.cheapflightsfinder.client.aviasales;

import by.kolodyuk.cheapflightsfinder.client.aviasales.model.AviasalesFightSearchResponse;
import by.kolodyuk.cheapflightsfinder.client.aviasales.model.Flight;
import by.kolodyuk.cheapflightsfinder.model.FlightRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AviasalesClient {

    public static String API_URL = "http://api.travelpayouts.com";
    public static String API_PATH = "/v2/prices/latest";

    @Autowired
    private RestTemplate restTemplate;

    public List<FlightRecord> getFlightsSummary() {
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

    private FlightRecord convert(Flight flight) {
        FlightRecord flightRecord = new FlightRecord();
        flightRecord.setPrice(flight.getPrice() + "€");
        flightRecord.setFromCity(flight.getOrigin());
        flightRecord.setToCity(flight.getDestination());
        flightRecord.setFromDate(flight.getDepartDate().format(DateTimeFormatter.ofPattern("MMM dd")));
        flightRecord.setToDate(flight.getReturnDate().format(DateTimeFormatter.ofPattern("MMM dd")));

        return flightRecord;
    }

}
