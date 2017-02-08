package com.jesusgsdev.suppliers.toughjet.dto;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by jesgarsal on 08/02/17.
 */
public class ToughJetResponseDTOTest {

    private List<ToughJetResponseDTO> dtos;

    @Before
    public void before() throws Exception{
        dtos = new LinkedList<>();

        ToughJetResponseDTO toughJetResponseDTO = ToughJetResponseDTO.newToughJetResponseDTO()
                .carrier("Ryanair")
                .basePrice(100.00)
                .tax(20.0)
                .discount(5.0)
                .departureAirportName("STN")
                .arrivalAirportName("SVQ")
                .departureDay(1).departureMonth(1).departureYear(2018)
                .returnDay(9).returnMonth(1).returnYear(2018)
                .build();

        dtos.add(toughJetResponseDTO);

        toughJetResponseDTO = ToughJetResponseDTO.newToughJetResponseDTO()
                .carrier("Ryanair")
                .basePrice(100.00)
                .tax(20.0)
                .discount(5.0)
                .departureAirportName("STN")
                .arrivalAirportName("SVQ")
                .departureDay(1).departureMonth(1).departureYear(2018)
                .returnDay(9).returnMonth(1).returnYear(2018)
                .build();

        dtos.add(toughJetResponseDTO);

        toughJetResponseDTO = ToughJetResponseDTO.newToughJetResponseDTO()
                .carrier("Ryanair")
                .basePrice(150.00)
                .tax(20.0)
                .discount(5.0)
                .departureAirportName("STN")
                .arrivalAirportName("SVQ")
                .departureDay(1).departureMonth(1).departureYear(2018)
                .returnDay(9).returnMonth(1).returnYear(2018)
                .build();

        dtos.add(toughJetResponseDTO);
    }

    @Test
    public void createToughJetResponseDTO(){
        ToughJetResponseDTO toughJetResponseDTO = dtos.get(0);

        assertEquals(toughJetResponseDTO.getCarrier(), "Ryanair");
        assertEquals(toughJetResponseDTO.getBasePrice(), new Double(100.00));
        assertEquals(toughJetResponseDTO.getTax(), new Double(20));
        assertEquals(toughJetResponseDTO.getDiscount(), new Double(5));
        assertEquals(toughJetResponseDTO.getDepartureAirportName(), "STN");
        assertEquals(toughJetResponseDTO.getArrivalAirportName(), "SVQ");
        assertEquals(toughJetResponseDTO.getDepartureDay(), new Integer(1));
        assertEquals(toughJetResponseDTO.getDepartureMonth(), new Integer(1));
        assertEquals(toughJetResponseDTO.getDepartureYear(), new Integer(2018));
        assertEquals(toughJetResponseDTO.getReturnDay(), new Integer(9));
        assertEquals(toughJetResponseDTO.getReturnMonth(), new Integer(1));
        assertEquals(toughJetResponseDTO.getReturnYear(), new Integer(2018));
    }

    @Test
    public void compareEqualsToughJetResponseDTO(){
        ToughJetResponseDTO toughJetResponseDTOA = dtos.get(0);
        ToughJetResponseDTO toughJetResponseDTOB = dtos.get(1);

        assertEquals(toughJetResponseDTOA, toughJetResponseDTOB);
    }

    @Test
    public void hashCodeTest(){
        ToughJetResponseDTO toughJetResponseDTOA = dtos.get(0);
        ToughJetResponseDTO toughJetResponseDTOB = dtos.get(1);

        assertEquals(toughJetResponseDTOA.hashCode(), toughJetResponseDTOB.hashCode());
    }

    @Test
    public void compareNotEqualsToughJetResponseDTO(){
        ToughJetResponseDTO toughJetResponseDTOA = dtos.get(0);
        ToughJetResponseDTO toughJetResponseDTOB = dtos.get(2);

        assertNotEquals(toughJetResponseDTOA, toughJetResponseDTOB);
    }
}
