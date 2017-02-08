package com.jesusgsdev.busyflights.dto;

import com.jesusgsdev.validators.ValidDatesInTime;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by jesgarsal on 29/01/17.
 */
@ValidDatesInTime
public class BusyFlightsRequestDTO implements Serializable {

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

    public BusyFlightsRequestDTO() {
    }

    private BusyFlightsRequestDTO(Builder builder) {
        this.origin = builder.origin;
        this.destination = builder.destination;
        this.departureDate = builder.departureDate;
        this.returnDate = builder.returnDate;
        this.numberOfPassengers = builder.numberOfPassengers;
    }

    public static Builder newBusyFlightsRequestDTO() {
        return new Builder();
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
        if (!(o instanceof BusyFlightsRequestDTO)) return false;
        BusyFlightsRequestDTO that = (BusyFlightsRequestDTO) o;
        return Objects.equals(origin, that.origin) &&
                Objects.equals(destination, that.destination) &&
                Objects.equals(departureDate, that.departureDate) &&
                Objects.equals(returnDate, that.returnDate) &&
                Objects.equals(numberOfPassengers, that.numberOfPassengers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origin, destination, departureDate, returnDate, numberOfPassengers);
    }

    public static final class Builder {
        private String origin;
        private String destination;
        private String departureDate;
        private String returnDate;
        private Integer numberOfPassengers;

        private Builder() {
        }

        public BusyFlightsRequestDTO build() {
            return new BusyFlightsRequestDTO(this);
        }

        public Builder origin(String origin) {
            this.origin = origin;
            return this;
        }

        public Builder destination(String destination) {
            this.destination = destination;
            return this;
        }

        public Builder departureDate(String departureDate) {
            this.departureDate = departureDate;
            return this;
        }

        public Builder returnDate(String returnDate) {
            this.returnDate = returnDate;
            return this;
        }

        public Builder numberOfPassengers(Integer numberOfPassengers) {
            this.numberOfPassengers = numberOfPassengers;
            return this;
        }
    }
}
