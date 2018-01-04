
package by.kolodyuk.cheapflightsfinder.client.ryanair.model;


public class Price {

    private Double value;
    private String valueMainUnit;
    private String valueFractionalUnit;
    private String currencyCode;
    private String currencySymbol;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getValueMainUnit() {
        return valueMainUnit;
    }

    public void setValueMainUnit(String valueMainUnit) {
        this.valueMainUnit = valueMainUnit;
    }

    public String getValueFractionalUnit() {
        return valueFractionalUnit;
    }

    public void setValueFractionalUnit(String valueFractionalUnit) {
        this.valueFractionalUnit = valueFractionalUnit;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

}
