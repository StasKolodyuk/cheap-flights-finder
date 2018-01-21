package by.kolodyuk.cheapflightsfinder.printer;

import by.kolodyuk.cheapflightsfinder.api.FlightExtended;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class FlightPrinter {

    public static final String N_A = "Location Unavailable";

    public String toString(FlightExtended flight) {
        return getPrice(flight) + " " + getFlightInfo(flight) + " on " + getDates(flight);
    }

    public String getPrice(FlightExtended flight) {
        return String.format("%.2f%s", flight.getPrice(), flight.getCurrency());
    }

    public String getFlightInfo(FlightExtended flight) {
        return "From " + getStartingPoint(flight) + " to " + getDestinationPoint(flight);
    }

    public String getStartingPoint(FlightExtended flight) {
        return flight.getFromAirportIataCode() + " (" + getFromLocation(flight) + ")";
    }

    public String getDestinationPoint(FlightExtended flight) {
        return flight.getToAirportIataCode() + " (" + getToLocation(flight) + ")";
    }

    public String getFromLocation(FlightExtended flight) {
        if (flight.getFromCity() == null) {
            return N_A;
        }

        return flight.getFromCity() + ", " + flight.getFromCountry();
    }

    public String getToLocation(FlightExtended flight) {
        if (flight.getToCity() == null) {
            return N_A;
        }

        return flight.getToCity() + ", " + flight.getToCountry();
    }

    public String getDates(FlightExtended flight) {
        return formatDate(flight.getFromDate()) + " - " + formatDate(flight.getToDate());
    }

    public String formatDate(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern("MMM dd"));
    }

}
