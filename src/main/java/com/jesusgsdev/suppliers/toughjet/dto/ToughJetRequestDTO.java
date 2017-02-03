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
}
