package com.jesusgsdev.busyflights.dto;

import com.jesusgsdev.validators.ValidDatesInTime;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by jesgarsal on 29/01/17.
 */
@ValidDatesInTime
public class BusyFlightsSearchDTO implements Serializable {

    @Size(min = 3, max = 3)
    private String origin;

    @Size(min = 3, max = 3)
    private String destination;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.NONE)
    private String departureDate;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.NONE)
    private String returnDate;

    @Range(min = 1, max = 4)
    private Integer numberOfPassengers;

    public BusyFlightsSearchDTO() {
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(Integer numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public String toString() {
        return "{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", numberOfPassengers=" + numberOfPassengers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BusyFlightsSearchDTO that = (BusyFlightsSearchDTO) o;

        if (origin != null ? !origin.equals(that.origin) : that.origin != null) return false;
        if (destination != null ? !destination.equals(that.destination) : that.destination != null) return false;
        if (departureDate != null ? !departureDate.equals(that.departureDate) : that.departureDate != null)
            return false;
        if (returnDate != null ? !returnDate.equals(that.returnDate) : that.returnDate != null) return false;
        return numberOfPassengers != null ? numberOfPassengers.equals(that.numberOfPassengers) : that.numberOfPassengers == null;
    }

    @Override
    public int hashCode() {
        int result = origin != null ? origin.hashCode() : 0;
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (departureDate != null ? departureDate.hashCode() : 0);
        result = 31 * result + (returnDate != null ? returnDate.hashCode() : 0);
        result = 31 * result + (numberOfPassengers != null ? numberOfPassengers.hashCode() : 0);
        return result;
    }
}
