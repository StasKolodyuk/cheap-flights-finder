package by.kolodyuk.cheapflightsfinder.client.aviasales.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Flight {

    @JsonProperty("value")
    private double price;
    @JsonProperty("trip_class")
    private int tripClass;
    @JsonProperty("show_to_affiliates")
    private boolean showToAffiliates;
    @JsonProperty("return_date")
    private LocalDate returnDate;
    private String origin;
    @JsonProperty("number_of_changes")
    private int numberOfChanges;
    private String gate;
    @JsonProperty("found_at")
    private LocalDateTime foundAt;
    private int duration;
    private int distance;
    private String destination;
    @JsonProperty("depart_date")
    private LocalDate departDate;
    private boolean actual;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTripClass() {
        return tripClass;
    }

    public void setTripClass(int tripClass) {
        this.tripClass = tripClass;
    }

    public boolean isShowToAffiliates() {
        return showToAffiliates;
    }

    public void setShowToAffiliates(boolean showToAffiliates) {
        this.showToAffiliates = showToAffiliates;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getNumberOfChanges() {
        return numberOfChanges;
    }

    public void setNumberOfChanges(int numberOfChanges) {
        this.numberOfChanges = numberOfChanges;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public LocalDateTime getFoundAt() {
        return foundAt;
    }

    public void setFoundAt(LocalDateTime foundAt) {
        this.foundAt = foundAt;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDepartDate() {
        return departDate;
    }

    public void setDepartDate(LocalDate departDate) {
        this.departDate = departDate;
    }

    public boolean isActual() {
        return actual;
    }

    public void setActual(boolean actual) {
        this.actual = actual;
    }
}
