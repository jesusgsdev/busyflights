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
public class CrazyAirRequestDTOTest {

    public static final String STN = "STN";
    public static final String SVQ = "SVQ";
    public static final int YEAR_2018 = 2018;
    public static final int JANUARY = 1;

    private List<CrazyAirRequestDTO> dtos;

    @Before
    public void before() throws Exception{
        setUpDTOs();
    }

    @Test
    public void createCrazyAirRequestDTO(){
        CrazyAirRequestDTO crazyAirRequestDTO = dtos.get(0);

        assertEquals(crazyAirRequestDTO.getNumberOfPassengers(), new Integer(4));
        assertEquals(crazyAirRequestDTO.getOrigin(), STN);
        assertEquals(crazyAirRequestDTO.getDestination(), SVQ);
        assertEquals(crazyAirRequestDTO.getDepartureDate(), DateHelpers.getStringDateISO8601(YEAR_2018,JANUARY,1));
        assertEquals(crazyAirRequestDTO.getReturnDate(), DateHelpers.getStringDateISO8601(YEAR_2018,JANUARY,9));
    }

    @Test
    public void compareEqualsCrazyAirRequestDTO(){
        CrazyAirRequestDTO crazyAirRequestDTOA = dtos.get(0);
        CrazyAirRequestDTO crazyAirRequestDTOB = dtos.get(1);

        assertEquals(crazyAirRequestDTOA, crazyAirRequestDTOB);
    }

    @Test
    public void hashCodeTest(){
        CrazyAirRequestDTO crazyAirRequestDTOA = dtos.get(0);
        CrazyAirRequestDTO crazyAirRequestDTOB = dtos.get(1);

        assertEquals(crazyAirRequestDTOA.hashCode(), crazyAirRequestDTOB.hashCode());
    }

    @Test
    public void compareNotEqualsCrazyAirRequestDTO(){
        CrazyAirRequestDTO crazyAirRequestDTOA = dtos.get(0);
        CrazyAirRequestDTO crazyAirRequestDTOB = dtos.get(2);

        assertNotEquals(crazyAirRequestDTOA, crazyAirRequestDTOB);
    }

    private void setUpDTOs() {
        dtos = new LinkedList<>();

        CrazyAirRequestDTO crazyAirRequestDTO =
                CrazyAirRequestDTO.newCrazyAirRequestDTO()
                        .numberOfPassengers(4)
                        .origin(STN)
                        .destination(SVQ)
                        .departureDate(DateHelpers.getStringDateISO8601(YEAR_2018, JANUARY,1))
                        .returnDate(DateHelpers.getStringDateISO8601(YEAR_2018,JANUARY,9))
                        .build();
        dtos.add(crazyAirRequestDTO);

        crazyAirRequestDTO = CrazyAirRequestDTO.newCrazyAirRequestDTO()
                .numberOfPassengers(4)
                .origin(STN)
                .destination(SVQ)
                .departureDate(DateHelpers.getStringDateISO8601(YEAR_2018,JANUARY,1))
                .returnDate(DateHelpers.getStringDateISO8601(YEAR_2018,JANUARY,9))
                .build();
        dtos.add(crazyAirRequestDTO);

        crazyAirRequestDTO = CrazyAirRequestDTO.newCrazyAirRequestDTO()
                .numberOfPassengers(5)
                .origin(STN)
                .destination(SVQ)
                .departureDate(DateHelpers.getStringDateISO8601(YEAR_2018,JANUARY,1))
                .returnDate(DateHelpers.getStringDateISO8601(YEAR_2018,JANUARY,9))
                .build();
        dtos.add(crazyAirRequestDTO);
    }


}
