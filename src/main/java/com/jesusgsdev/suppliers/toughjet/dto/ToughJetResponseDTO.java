package com.jesusgsdev.suppliers.toughjet.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by jesgarsal on 29/01/17.
 */
public class ToughJetResponseDTO extends ToughJetCommonDTO implements Serializable{

    @NotBlank
    private String carrier;

    private Double basePrice;
    private Double tax;

    @Range(min = 0, max = 100)
    private Double discount;

    @Size(min=3, max=3)
    private String departureAirportName;

    @Size(min=3, max=3)
    private String arrivalAirportName;

    public ToughJetResponseDTO() {
        super();
    }

    private ToughJetResponseDTO(Builder builder) {
        this.carrier = builder.carrier;
        this.basePrice = builder.basePrice;
        this.tax = builder.tax;
        this.discount = builder.discount;
        this.departureAirportName = builder.departureAirportName;
        this.arrivalAirportName = builder.arrivalAirportName;
        super.setDepartureDay(builder.departureDay);
        super.setDepartureMonth(builder.departureMonth);
        super.setDepartureYear(builder.departureYear);
        super.setReturnDay(builder.returnDay);
        super.setReturnMonth(builder.returnMonth);
        super.setReturnYear(builder.returnYear);
    }

    public static Builder newToughJetResponseDTO() {
        return new Builder();
    }


    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public static final class Builder {
        private String carrier;
        private Double basePrice;
        private Double tax;
        private Double discount;
        private String departureAirportName;
        private String arrivalAirportName;
        private Integer departureDay;
        private Integer departureMonth;
        private Integer departureYear;
        private Integer returnDay;
        private Integer returnMonth;
        private Integer returnYear;

        private Builder() {
        }

        public ToughJetResponseDTO build() {
            return new ToughJetResponseDTO(this);
        }

        public Builder carrier(String carrier) {
            this.carrier = carrier;
            return this;
        }

        public Builder basePrice(Double basePrice) {
            this.basePrice = basePrice;
            return this;
        }

        public Builder tax(Double tax) {
            this.tax = tax;
            return this;
        }

        public Builder discount(Double discount) {
            this.discount = discount;
            return this;
        }

        public Builder departureAirportName(String departureAirportName) {
            this.departureAirportName = departureAirportName;
            return this;
        }

        public Builder arrivalAirportName(String arrivalAirportName) {
            this.arrivalAirportName = arrivalAirportName;
            return this;
        }

        public Builder departureDay(Integer departureDay) {
            this.departureDay = departureDay;
            return this;
        }

        public Builder departureMonth(Integer departureMonth) {
            this.departureMonth = departureMonth;
            return this;
        }

        public Builder departureYear(Integer departureYear) {
            this.departureYear = departureYear;
            return this;
        }

        public Builder returnDay(Integer returnDay) {
            this.returnDay = returnDay;
            return this;
        }

        public Builder returnMonth(Integer returnMonth) {
            this.returnMonth = returnMonth;
            return this;
        }

        public Builder returnYear(Integer returnYear) {
            this.returnYear = returnYear;
            return this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToughJetResponseDTO that = (ToughJetResponseDTO) o;

        if (carrier != null ? !carrier.equals(that.carrier) : that.carrier != null) return false;
        if (basePrice != null ? !basePrice.equals(that.basePrice) : that.basePrice != null) return false;
        if (tax != null ? !tax.equals(that.tax) : that.tax != null) return false;
        if (discount != null ? !discount.equals(that.discount) : that.discount != null) return false;
        if (departureAirportName != null ? !departureAirportName.equals(that.departureAirportName) : that.departureAirportName != null)
            return false;
        return arrivalAirportName != null ? arrivalAirportName.equals(that.arrivalAirportName) : that.arrivalAirportName == null;
    }

    @Override
    public int hashCode() {
        int result = carrier != null ? carrier.hashCode() : 0;
        result = 31 * result + (basePrice != null ? basePrice.hashCode() : 0);
        result = 31 * result + (tax != null ? tax.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + (departureAirportName != null ? departureAirportName.hashCode() : 0);
        result = 31 * result + (arrivalAirportName != null ? arrivalAirportName.hashCode() : 0);
        return result;
    }
}
