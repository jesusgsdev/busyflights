package com.jesusgsdev.suppliers.toughjet.dto;

import org.hibernate.validator.constraints.Range;

import java.io.Serializable;

/**
 * Created by jesgarsal on 29/01/17.
 */
public class ToughJetCommonDTO implements Serializable{

    @Range(min = 1, max = 31)
    private Integer departureDay;

    @Range(min = 1, max = 12)
    private Integer departureMonth;

    @Range(min = 2017, max = 3000)
    private Integer departureYear;

    @Range(min = 1, max = 31)
    private Integer returnDay;

    @Range(min = 1, max = 12)
    private Integer returnMonth;

    @Range(min = 2017, max = 3000)
    private Integer returnYear;

    public ToughJetCommonDTO() {
    }

    public Integer getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(Integer departureDay) {
        this.departureDay = departureDay;
    }

    public Integer getDepartureMonth() {
        return departureMonth;
    }

    public void setDepartureMonth(Integer departureMonth) {
        this.departureMonth = departureMonth;
    }

    public Integer getDepartureYear() {
        return departureYear;
    }

    public void setDepartureYear(Integer departureYear) {
        this.departureYear = departureYear;
    }

    public Integer getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(Integer returnDay) {
        this.returnDay = returnDay;
    }

    public Integer getReturnMonth() {
        return returnMonth;
    }

    public void setReturnMonth(Integer returnMonth) {
        this.returnMonth = returnMonth;
    }

    public Integer getReturnYear() {
        return returnYear;
    }

    public void setReturnYear(Integer returnYear) {
        this.returnYear = returnYear;
    }
}
