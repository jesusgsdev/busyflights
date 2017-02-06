package com.jesusgsdev.suppliers.toughjet.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by jesgarsal on 29/01/17.
 */
public class ToughJetRequestDTO extends ToughJetCommonDTO implements Serializable{

    @Size(min=3, max=3)
    private String from;

    @Size(min=3, max=3)
    private String to;

    @Range(min = 1, max = 4)
    private Integer numberOfAdults;

    public ToughJetRequestDTO() {
        super();
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }


    public Integer getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(Integer numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToughJetRequestDTO that = (ToughJetRequestDTO) o;

        if (from != null ? !from.equals(that.from) : that.from != null) return false;
        if (to != null ? !to.equals(that.to) : that.to != null) return false;
        return numberOfAdults != null ? numberOfAdults.equals(that.numberOfAdults) : that.numberOfAdults == null;
    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (numberOfAdults != null ? numberOfAdults.hashCode() : 0);
        return result;
    }
}
