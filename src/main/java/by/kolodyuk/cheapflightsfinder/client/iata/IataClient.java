package by.kolodyuk.cheapflightsfinder.client.iata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import by.kolodyuk.cheapflightsfinder.client.iata.model.Airport;

@Component
public class IataClient {

    public static String API_URL = "http://www.airport-data.com";
    public static String API_PATH = "/api/ap_info.json";

    @Autowired
    private RestTemplate restTemplate;

    @Cacheable("iata")
    public Airport getAirportInfo(String iataCode) {
        return restTemplate.getForObject("http://www.airport-data.com/api/ap_info.json?iata={iataCode}", Airport.class, iataCode);
    }

}
