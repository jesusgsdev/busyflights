package com.jesusgsdev.suppliers.crazyair.dto;

import com.jesusgsdev.helpers.DateHelpers;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by jesgarsal on 08/02/17.
 */
public class CrazyAirResponseDTOTest {

    private List<CrazyAirResponseDTO> dtos;

    @Before
    public void before() throws Exception{
        dtos = new LinkedList<>();

        CrazyAirResponseDTO crazyAirResponseDTO =
                CrazyAirResponseDTO.newCrazyAirResponseDTO().airline("Ryanair")
                        .departureAirportCode("STN")
                        .destinationAirportCode("SVQ")
                        .departureDate(DateHelpers.getStringDateISO8601(2018,1,1))
                        .arrivalDate(DateHelpers.getStringDateISO8601(2018,1,9))
                        .cabinclass("E")
                        .price(180.50)
                        .build();
        dtos.add(crazyAirResponseDTO);

        crazyAirResponseDTO =
                CrazyAirResponseDTO.newCrazyAirResponseDTO().airline("Ryanair")
                .departureAirportCode("STN")
                .destinationAirportCode("SVQ")
                .departureDate(DateHelpers.getStringDateISO8601(2018,1,1))
                .arrivalDate(DateHelpers.getStringDateISO8601(2018,1,9))
                .cabinclass("E")
                .price(180.50)
                .build();
        dtos.add(crazyAirResponseDTO);

        crazyAirResponseDTO =
                CrazyAirResponseDTO.newCrazyAirResponseDTO().airline("Ryanair")
                .departureAirportCode("STN")
                .destinationAirportCode("SVQ")
                .departureDate(DateHelpers.getStringDateISO8601(2018,1,1))
                .arrivalDate(DateHelpers.getStringDateISO8601(2018,1,9))
                .cabinclass("E")
                .price(200.50)
                .build();
        dtos.add(crazyAirResponseDTO);
    }

    @Test
    public void createCrazyAirResponseDTO(){
        CrazyAirResponseDTO crazyAirResponseDTO = dtos.get(0);

        assertEquals(crazyAirResponseDTO.getAirline(), "Ryanair");
        assertEquals(crazyAirResponseDTO.getDepartureAirportCode(), "STN");
        assertEquals(crazyAirResponseDTO.getDestinationAirportCode(), "SVQ");
        assertEquals(crazyAirResponseDTO.getDepartureDate(), DateHelpers.getStringDateISO8601(2018,1,1));
        assertEquals(crazyAirResponseDTO.getArrivalDate(), DateHelpers.getStringDateISO8601(2018,1,9));
        assertEquals(crazyAirResponseDTO.getCabinclass(), "E");
        assertEquals(crazyAirResponseDTO.getPrice(), new Double(180.50));
    }

    @Test
    public void compareEqualsCrazyAirResponseDTO(){
        CrazyAirResponseDTO crazyAirResponseDTOA = dtos.get(0);
        CrazyAirResponseDTO crazyAirResponseDTOB = dtos.get(1);

        assertEquals(crazyAirResponseDTOA, crazyAirResponseDTOB);
    }

    @Test
    public void hashCodeTest(){
        CrazyAirResponseDTO crazyAirResponseDTOA = dtos.get(0);
        CrazyAirResponseDTO crazyAirResponseDTOB = dtos.get(1);

        assertEquals(crazyAirResponseDTOA.hashCode(), crazyAirResponseDTOB.hashCode());
    }

    @Test
    public void compareNotEqualsCrazyAirResponseDTO(){
        CrazyAirResponseDTO crazyAirResponseDTOA = dtos.get(0);
        CrazyAirResponseDTO crazyAirResponseDTOB = dtos.get(2);

        assertNotEquals(crazyAirResponseDTOA, crazyAirResponseDTOB);
    }
    
}
