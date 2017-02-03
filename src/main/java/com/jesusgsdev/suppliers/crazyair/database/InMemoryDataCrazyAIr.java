package com.jesusgsdev.suppliers.crazyair.database;

import com.jesusgsdev.helpers.DateHelpers;
import com.jesusgsdev.suppliers.crazyair.dto.CrazyAirResponseDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jesgarsal on 29/01/17.
 */
@Component
public class InMemoryDataCrazyAIr {

    public final List<CrazyAirResponseDTO> database = new ArrayList<>();

    public InMemoryDataCrazyAIr() {

        database.add(CrazyAirResponseDTO.newCrazyAirResponseDTO().airline("Ryanair")
                .departureAirportCode("STN")
                .destinationAirportCode("SVQ")
                .departureDate(DateHelpers.getStringDateISO8601(2018,1,1))
                .arrivalDate(DateHelpers.getStringDateISO8601(2018,1,9))
                .cabinclass("E").price(180.50).build());

        database.add(CrazyAirResponseDTO.newCrazyAirResponseDTO().airline("Vueling")
                .departureAirportCode("STN")
                .destinationAirportCode("SVQ")
                .departureDate(DateHelpers.getStringDateISO8601(2018,1,1))
                .arrivalDate(DateHelpers.getStringDateISO8601(2018,1,9))
                .cabinclass("B").price(380.50).build());

        database.add(CrazyAirResponseDTO.newCrazyAirResponseDTO().airline("British Airways")
                .departureAirportCode("CCC")
                .destinationAirportCode("DDD")
                .departureDate(DateHelpers.getStringDateISO8601(2018,2,1))
                .arrivalDate(DateHelpers.getStringDateISO8601(2018,2,9))
                .cabinclass("B").price(580.50).build());

    }
}
