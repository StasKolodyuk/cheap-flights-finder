package by.kolodyuk.cheapflightsfinder.api;

import java.util.List;

import static java.util.Arrays.asList;

public class FlightCriteria {

    public static final String MINSK_IATA_CODE = "MSQ";
    public static final String VILNIUS_IATA_CODE = "VNO";

    public static final double DEFAULT_MAX_PRICE = 50.0;
    public static final List<String> DEFAULT_STARTING_POINT_IATA_CODES = asList(MINSK_IATA_CODE, VILNIUS_IATA_CODE);
    public static final int DEFAULT_DURATION_FROM_DAYS = 1;
    public static final int DEFAULT_DURATION_TO_DAYS = 3;

    private double maxPrice = DEFAULT_MAX_PRICE;
    private List<String> startingPointIataCodes = DEFAULT_STARTING_POINT_IATA_CODES;
    private int durationFromDays = DEFAULT_DURATION_FROM_DAYS;
    private int durationToDays = DEFAULT_DURATION_TO_DAYS;

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public List<String> getStartingPointIataCodes() {
        return startingPointIataCodes;
    }

    public void setStartingPointIataCodes(List<String> startingPointIataCodes) {
        this.startingPointIataCodes = startingPointIataCodes;
    }

    public int getDurationFromDays() {
        return durationFromDays;
    }

    public void setDurationFromDays(int durationFromDays) {
        this.durationFromDays = durationFromDays;
    }

    public int getDurationToDays() {
        return durationToDays;
    }

    public void setDurationToDays(int durationToDays) {
        this.durationToDays = durationToDays;
    }
}
