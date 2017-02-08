package com.jesusgsdev.validators;

import com.jesusgsdev.busyflights.dto.BusyFlightsRequestDTO;
import com.jesusgsdev.helpers.DateHelpers;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

/**
 * Created by jesgarsal on 01/02/17.
 */
public class ValidDatesInTimeValidator implements ConstraintValidator<ValidDatesInTime, BusyFlightsRequestDTO> {

    @Override
    public void initialize(ValidDatesInTime constraint) {
    }

    @Override
    public boolean isValid(BusyFlightsRequestDTO json, ConstraintValidatorContext constraintValidatorContext) {
        try {
            LocalDate departureDate = DateHelpers.getLocalDateFromStringInISO8601(json.getDepartureDate());
            LocalDate returnDate = DateHelpers.getLocalDateFromStringInISO8601(json.getReturnDate());

            return returnDate.isAfter(departureDate);
        } catch (Exception e) {
            // log error
            return false;
        }
    }

}
