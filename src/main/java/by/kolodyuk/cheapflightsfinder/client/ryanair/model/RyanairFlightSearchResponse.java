
package by.kolodyuk.cheapflightsfinder.client.ryanair.model;

import java.util.List;

public class RyanairFlightSearchResponse {

    private Integer total;
    private Object arrivalAirportCategories;
    private List<Fare> fares = null;
    private Integer size;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Object getArrivalAirportCategories() {
        return arrivalAirportCategories;
    }

    public void setArrivalAirportCategories(Object arrivalAirportCategories) {
        this.arrivalAirportCategories = arrivalAirportCategories;
    }

    public List<Fare> getFares() {
        return fares;
    }

    public void setFares(List<Fare> fares) {
        this.fares = fares;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

}
