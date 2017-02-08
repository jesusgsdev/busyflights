package com.jesusgsdev.busyflights.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

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

    private BusyFlightsResponseDTO(Builder builder) {
        this.airline = builder.airline;
        this.supplier = builder.supplier;
        this.fare = builder.fare;
        this.departureAirportCode = builder.departureAirportCode;
        this.destinationAirportCode = builder.destinationAirportCode;
        this.departureDate = builder.departureDate;
        this.arrivalDate = builder.arrivalDate;
    }

    public static Builder newBusyFlightsResponseDTO() {
        return new Builder();
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
        if (!(o instanceof BusyFlightsResponseDTO)) return false;
        BusyFlightsResponseDTO that = (BusyFlightsResponseDTO) o;
        return Objects.equals(airline, that.airline) &&
                Objects.equals(supplier, that.supplier) &&
                Objects.equals(fare, that.fare) &&
                Objects.equals(departureAirportCode, that.departureAirportCode) &&
                Objects.equals(destinationAirportCode, that.destinationAirportCode) &&
                Objects.equals(departureDate, that.departureDate) &&
                Objects.equals(arrivalDate, that.arrivalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airline, supplier, fare, departureAirportCode, destinationAirportCode, departureDate, arrivalDate);
    }


    public static final class Builder {
        private String airline;
        private String supplier;
        private Double fare;
        private String departureAirportCode;
        private String destinationAirportCode;
        private String departureDate;
        private String arrivalDate;

        private Builder() {
        }

        public BusyFlightsResponseDTO build() {
            return new BusyFlightsResponseDTO(this);
        }

        public Builder airline(String airline) {
            this.airline = airline;
            return this;
        }

        public Builder supplier(String supplier) {
            this.supplier = supplier;
            return this;
        }

        public Builder fare(Double fare) {
            this.fare = fare;
            return this;
        }

        public Builder departureAirportCode(String departureAirportCode) {
            this.departureAirportCode = departureAirportCode;
            return this;
        }

        public Builder destinationAirportCode(String destinationAirportCode) {
            this.destinationAirportCode = destinationAirportCode;
            return this;
        }

        public Builder departureDate(String departureDate) {
            this.departureDate = departureDate;
            return this;
        }

        public Builder arrivalDate(String arrivalDate) {
            this.arrivalDate = arrivalDate;
            return this;
        }
    }
}
