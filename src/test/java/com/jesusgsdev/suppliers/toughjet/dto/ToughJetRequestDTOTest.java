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
public class ToughJetRequestDTOTest {

    private List<ToughJetRequestDTO> dtos;

    @Before
    public void before() throws Exception{
        dtos = new LinkedList<>();

        ToughJetRequestDTO toughJetRequestDTO = new ToughJetRequestDTO();
        toughJetRequestDTO.setNumberOfAdults(4);
        toughJetRequestDTO.setFrom("STN");
        toughJetRequestDTO.setTo("SVQ");
        toughJetRequestDTO.setDepartureDay(1);
        toughJetRequestDTO.setDepartureMonth(1);
        toughJetRequestDTO.setDepartureYear(2018);
        toughJetRequestDTO.setReturnDay(9);
        toughJetRequestDTO.setReturnMonth(1);
        toughJetRequestDTO.setReturnYear(2018);

        dtos.add(toughJetRequestDTO);

        toughJetRequestDTO = new ToughJetRequestDTO();
        toughJetRequestDTO.setNumberOfAdults(4);
        toughJetRequestDTO.setFrom("STN");
        toughJetRequestDTO.setTo("SVQ");
        toughJetRequestDTO.setDepartureDay(1);
        toughJetRequestDTO.setDepartureMonth(1);
        toughJetRequestDTO.setDepartureYear(2018);
        toughJetRequestDTO.setReturnDay(9);
        toughJetRequestDTO.setReturnMonth(1);
        toughJetRequestDTO.setReturnYear(2018);

        dtos.add(toughJetRequestDTO);

        toughJetRequestDTO = new ToughJetRequestDTO();
        toughJetRequestDTO.setNumberOfAdults(2);
        toughJetRequestDTO.setFrom("STN");
        toughJetRequestDTO.setTo("SVQ");
        toughJetRequestDTO.setDepartureDay(2);
        toughJetRequestDTO.setDepartureMonth(1);
        toughJetRequestDTO.setDepartureYear(2018);
        toughJetRequestDTO.setReturnDay(10);
        toughJetRequestDTO.setReturnMonth(1);
        toughJetRequestDTO.setReturnYear(2018);

        dtos.add(toughJetRequestDTO);
    }

    @Test
    public void createToughJetRequestDTO(){
        ToughJetRequestDTO toughJetRequestDTO = dtos.get(0);

        assertEquals(toughJetRequestDTO.getFrom(), "STN");
        assertEquals(toughJetRequestDTO.getTo(), "SVQ");
        assertEquals(toughJetRequestDTO.getDepartureDay(), new Integer(1));
        assertEquals(toughJetRequestDTO.getDepartureMonth(), new Integer(1));
        assertEquals(toughJetRequestDTO.getDepartureYear(), new Integer(2018));
        assertEquals(toughJetRequestDTO.getReturnDay(), new Integer(9));
        assertEquals(toughJetRequestDTO.getReturnMonth(), new Integer(1));
        assertEquals(toughJetRequestDTO.getReturnYear(), new Integer(2018));
        assertEquals(toughJetRequestDTO.getNumberOfAdults(), new Integer(4));
    }

    @Test
    public void compareEqualsToughJetRequestDTO(){
        ToughJetRequestDTO toughJetRequestDTOA = dtos.get(0);
        ToughJetRequestDTO toughJetRequestDTOB = dtos.get(1);

        assertEquals(toughJetRequestDTOA, toughJetRequestDTOB);
    }

    @Test
    public void hashCodeTest(){
        ToughJetRequestDTO toughJetRequestDTOA = dtos.get(0);
        ToughJetRequestDTO toughJetRequestDTOB = dtos.get(1);

        assertEquals(toughJetRequestDTOA.hashCode(), toughJetRequestDTOB.hashCode());
    }

    @Test
    public void compareNotEqualsToughJetRequestDTO(){
        ToughJetRequestDTO toughJetRequestDTOA = dtos.get(0);
        ToughJetRequestDTO toughJetRequestDTOB = dtos.get(2);

        assertNotEquals(toughJetRequestDTOA, toughJetRequestDTOB);
    }
}
