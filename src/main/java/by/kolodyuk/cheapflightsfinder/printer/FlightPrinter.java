package by.kolodyuk.cheapflightsfinder.printer;

import by.kolodyuk.cheapflightsfinder.api.FlightExtended;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class FlightPrinter {

    public static final String N_A = "Location Unavailable";

    public String toString(FlightExtended flight) {
        StringBuilder result = new StringBuilder();
        result.append(getPrice(flight) + " by " + flight.getSource() + "\n");
        result.append("From " + getStartingPoint(flight) + "\n");
        result.append("To " + getDestinationPoint(flight) + "\n");
        result.append("On " + formatDate(flight.getFromDate()) + " - " + formatDate(flight.getToDate()) + "\n");

        return result.toString();
    }

    public String getPrice(FlightExtended flight) {
        return String.format("%.2f%s", flight.getPrice(), flight.getCurrency());
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

    public String formatDate(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern("MMM dd"));
    }

}
