package com.jesusgsdev.busyflights.dto;

import com.jesusgsdev.helpers.DateHelpers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by jesgarsal on 08/02/17.
 */
public class BusyFlightsDTOTest {

    private List<BusyFlightsRequestDTO> dtos;

    @Before
    public void before() throws Exception{
        dtos = new LinkedList<>();

        BusyFlightsRequestDTO busyFlightsRequestDTO =
                BusyFlightsRequestDTO.newBusyFlightsRequestDTO()
                    .numberOfPassengers(4)
                    .origin("STN")
                    .destination("SVQ")
                    .departureDate(DateHelpers.getStringDateISO8601(2018,1,1))
                    .returnDate(DateHelpers.getStringDateISO8601(2018,1,9))
                .build();
        dtos.add(busyFlightsRequestDTO);

        busyFlightsRequestDTO = BusyFlightsRequestDTO.newBusyFlightsRequestDTO()
                    .numberOfPassengers(4)
                    .origin("STN")
                    .destination("SVQ")
                    .departureDate(DateHelpers.getStringDateISO8601(2018,1,1))
                    .returnDate(DateHelpers.getStringDateISO8601(2018,1,9))
                .build();
        dtos.add(busyFlightsRequestDTO);

        busyFlightsRequestDTO = BusyFlightsRequestDTO.newBusyFlightsRequestDTO()
                    .numberOfPassengers(5)
                    .origin("STN")
                    .destination("SVQ")
                    .departureDate(DateHelpers.getStringDateISO8601(2018,1,1))
                    .returnDate(DateHelpers.getStringDateISO8601(2018,1,9))
                .build();
        dtos.add(busyFlightsRequestDTO);
    }

    @Test
    public void createBusyFlightsRequestDTO(){
        BusyFlightsRequestDTO busyFlightsRequestDTO = dtos.get(0);

        assertEquals(busyFlightsRequestDTO.getNumberOfPassengers(), new Integer(4));
        assertEquals(busyFlightsRequestDTO.getOrigin(), "STN");
        assertEquals(busyFlightsRequestDTO.getDestination(), "SVQ");
        assertEquals(busyFlightsRequestDTO.getDepartureDate(), DateHelpers.getStringDateISO8601(2018,1,1));
        assertEquals(busyFlightsRequestDTO.getReturnDate(), DateHelpers.getStringDateISO8601(2018,1,9));
    }

    @Test
    public void compareEqualsBusyFlightsRequestDTO(){
        BusyFlightsRequestDTO busyFlightsRequestDTOA = dtos.get(0);
        BusyFlightsRequestDTO busyFlightsRequestDTOB = dtos.get(1);

        assertEquals(busyFlightsRequestDTOA, busyFlightsRequestDTOB);
    }

    @Test
    public void hashCodeTest(){
        BusyFlightsRequestDTO busyFlightsRequestDTOA = dtos.get(0);
        BusyFlightsRequestDTO busyFlightsRequestDTOB = dtos.get(1);

        assertEquals(busyFlightsRequestDTOA.hashCode(), busyFlightsRequestDTOB.hashCode());
    }

    @Test
    public void compareNotEqualsBusyFlightsRequestDTO(){
        BusyFlightsRequestDTO busyFlightsRequestDTOA = dtos.get(0);
        BusyFlightsRequestDTO busyFlightsRequestDTOB = dtos.get(2);

        assertNotEquals(busyFlightsRequestDTOA, busyFlightsRequestDTOB);
    }
    
    @Test
    public void testToString(){
        BusyFlightsRequestDTO busyFlightsRequestDTOA = dtos.get(0);
        
        String toString =   "{" +
                    "origin='" + busyFlightsRequestDTOA.getOrigin() + '\'' +
                    ", destination='" + busyFlightsRequestDTOA.getDestination() + '\'' +
                    ", departureDate='" + busyFlightsRequestDTOA.getDepartureDate() + '\'' +
                    ", returnDate='" + busyFlightsRequestDTOA.getReturnDate() + '\'' +
                    ", numberOfPassengers=" + busyFlightsRequestDTOA.getNumberOfPassengers() +
                    '}';

        Assert.assertEquals(toString, busyFlightsRequestDTOA.toString());
    }
    
}
