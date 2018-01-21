package by.kolodyuk.cheapflightsfinder.api;


import java.time.LocalDate;
import java.util.Comparator;

public class Flight {

    public static final Character EUR = '€';
    public static final Comparator<Flight> PRICE_COMPARATOR = Comparator.comparing(Flight::getPrice);

    private Double price;
    private Character currency;

    private String source;

    private String fromAirportIataCode;
    private LocalDate fromDate;

    private String toAirportIataCode;
    private LocalDate toDate;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Character getCurrency() {
        return currency;
    }

    public void setCurrency(Character currency) {
        this.currency = currency;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFromAirportIataCode() {
        return fromAirportIataCode;
    }

    public void setFromAirportIataCode(String fromAirportIataCode) {
        this.fromAirportIataCode = fromAirportIataCode;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public String getToAirportIataCode() {
        return toAirportIataCode;
    }

    public void setToAirportIataCode(String toAirportIataCode) {
        this.toAirportIataCode = toAirportIataCode;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }
}
