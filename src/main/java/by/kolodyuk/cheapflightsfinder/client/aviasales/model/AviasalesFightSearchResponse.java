package by.kolodyuk.cheapflightsfinder.client.aviasales.model;


import java.util.List;

public class AviasalesFightSearchResponse {

    private boolean success;
    private List<Flight> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Flight> getData() {
        return data;
    }

    public void setData(List<Flight> data) {
        this.data = data;
    }
}
