package com.jesusgsdev.busyflights.services;

import com.jesusgsdev.busyflights.dto.BusyFlightsSearchDTO;
import com.jesusgsdev.exceptions.ValidationException;
import org.springframework.stereotype.Service;

/**
 * Created by jesgarsal on 29/01/17.
 */
@Service
public class BusyFlightsServiceValidator {

    public void validateBusyFlightInput(BusyFlightsSearchDTO busyFlightsSearchDTO){
       validateInput(busyFlightsSearchDTO.getOrigin(), busyFlightsSearchDTO.getDestination());
    }

    private void validateInput(String origin, String destination){

        if(origin.length() == 3){
            throw new ValidationException(origin+  " must be 3 letter IATA code(eg. LHR, AMS)");
        }

        if(destination.length() == 3){
            throw new ValidationException(destination+  " must be 3 letter IATA code(eg. LHR, AMS)");
        }

    }

}
