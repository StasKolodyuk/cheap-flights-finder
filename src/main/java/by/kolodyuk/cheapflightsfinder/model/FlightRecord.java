package by.kolodyuk.cheapflightsfinder.model;


import java.util.Comparator;

public class FlightRecord {

    public static final Comparator<FlightRecord> PRICE_COMPARATOR = Comparator.comparing(FlightRecord::getPrice);

    String price;
    String fromCity;
    String toCity;
    String fromDate;
    String toDate;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return price + " to "+ toCity + " (" + fromDate + " - " + toDate + ")";
    }
}
