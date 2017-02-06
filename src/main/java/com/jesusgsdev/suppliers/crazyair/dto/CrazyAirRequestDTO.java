package com.jesusgsdev.suppliers.crazyair.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by jesgarsal on 29/01/17.
 */
public class CrazyAirRequestDTO implements Serializable{

    @Size(min=3, max=3)
    private String origin;

    @Size(min=3, max=3)
    private String destination;

    private String departureDate;
    private String returnDate;

    @Range(min = 1, max = 4)
    private Integer numberOfPassengers;

    public CrazyAirRequestDTO() {
    }

    private CrazyAirRequestDTO(Builder builder) {
        this.origin = builder.origin;
        this.destination = builder.destination;
        this.departureDate = builder.departureDate;
        this.returnDate = builder.returnDate;
        this.numberOfPassengers = builder.numberOfPassengers;
    }

    public static Builder newCrazyAirRequestDTO() {
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


    public static final class Builder {
        private String origin;
        private String destination;
        private String departureDate;
        private String returnDate;
        private Integer numberOfPassengers;

        private Builder() {
        }

        public CrazyAirRequestDTO build() {
            return new CrazyAirRequestDTO(this);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CrazyAirRequestDTO that = (CrazyAirRequestDTO) o;

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
