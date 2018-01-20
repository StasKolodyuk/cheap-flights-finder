package by.kolodyuk.cheapflightsfinder.client.iata;

import by.kolodyuk.cheapflightsfinder.client.iata.model.IataResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;

@Component
public class IataClient {

    public static String API_URL = "https://openflights.org";
    public static String API_PATH = "/php/apsearch.php";

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RestTemplate restTemplate;

    @Cacheable("iata")
    public IataResponse getAirportInfo(String iataCode) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("iata", iataCode);
        formData.add("country", "ALL");
        formData.add("dst", "U");
        formData.add("db", "airports");
        formData.add("iatafilter", "true");
        formData.add("action", "SEARCH");
        formData.add("offset", "0");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(formData, headers);

        try {
            return objectMapper.readValue(restTemplate.postForObject(API_URL + API_PATH, request, String.class), IataResponse.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse Iata Response");
        }
    }

}
