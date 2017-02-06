package com.jesusgsdev.busyflights.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by jesgarsal on 29/01/17.
 */
public class BusyFlightsResponseDTO implements Serializable {

    @NotEmpty
    private String airline;

    @NotEmpty
    private String supplier;

    @NotNull
    private Double fare;

    @NotNull
    @Size(min = 3, max = 3)
    private String departureAirportCode;

    @NotNull
    @Size(min = 3, max = 3)
    private String destinationAirportCode;

    @NotNull
    private String departureDate;

    @NotNull
    private String arrivalDate;

    public BusyFlightsResponseDTO() {
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public String toString() {
        return "{" +
                "airline='" + airline + '\'' +
                ", supplier='" + supplier + '\'' +
                ", fare=" + fare +
                ", departureAirportCode='" + departureAirportCode + '\'' +
                ", destinationAirportCode='" + destinationAirportCode + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BusyFlightsResponseDTO that = (BusyFlightsResponseDTO) o;

        if (airline != null ? !airline.equals(that.airline) : that.airline != null) return false;
        if (supplier != null ? !supplier.equals(that.supplier) : that.supplier != null) return false;
        if (fare != null ? !fare.equals(that.fare) : that.fare != null) return false;
        if (departureAirportCode != null ? !departureAirportCode.equals(that.departureAirportCode) : that.departureAirportCode != null)
            return false;
        if (destinationAirportCode != null ? !destinationAirportCode.equals(that.destinationAirportCode) : that.destinationAirportCode != null)
            return false;
        if (departureDate != null ? !departureDate.equals(that.departureDate) : that.departureDate != null)
            return false;
        return arrivalDate != null ? arrivalDate.equals(that.arrivalDate) : that.arrivalDate == null;
    }

    @Override
    public int hashCode() {
        int result = airline != null ? airline.hashCode() : 0;
        result = 31 * result + (supplier != null ? supplier.hashCode() : 0);
        result = 31 * result + (fare != null ? fare.hashCode() : 0);
        result = 31 * result + (departureAirportCode != null ? departureAirportCode.hashCode() : 0);
        result = 31 * result + (destinationAirportCode != null ? destinationAirportCode.hashCode() : 0);
        result = 31 * result + (departureDate != null ? departureDate.hashCode() : 0);
        result = 31 * result + (arrivalDate != null ? arrivalDate.hashCode() : 0);
        return result;
    }
}
