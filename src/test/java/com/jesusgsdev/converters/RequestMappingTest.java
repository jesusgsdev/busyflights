package com.jesusgsdev.converters;

import com.jesusgsdev.Application;
import com.jesusgsdev.busyflights.dto.BusyFlightsRequestDTO;
import com.jesusgsdev.helpers.DateHelpers;
import com.jesusgsdev.mappings.configurable.BusyFlightToCrazyAirRequestMapper;
import com.jesusgsdev.mappings.configurable.BusyFlightToToughJetRequestMapper;
import com.jesusgsdev.suppliers.crazyair.dto.CrazyAirRequestDTO;
import com.jesusgsdev.suppliers.toughjet.dto.ToughJetRequestDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by jesgarsal on 02/02/17.
 */

@ComponentScan
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RequestMappingTest {

    @Test
    public void busyFlightToCrazyAirRequest(){
        BusyFlightsRequestDTO busyFlightsRequestDTO = new BusyFlightsRequestDTO();
        busyFlightsRequestDTO.setDepartureDate(DateHelpers.getStringDateISO8601(2017,10,9));
        busyFlightsRequestDTO.setReturnDate(DateHelpers.getStringDateISO8601(2017,10,17));
        busyFlightsRequestDTO.setOrigin("SVQ");
        busyFlightsRequestDTO.setDestination("STN");
        busyFlightsRequestDTO.setNumberOfPassengers(1);


        BusyFlightToCrazyAirRequestMapper busyFlightToCrazyAirRequestMapper = new BusyFlightToCrazyAirRequestMapper();
        CrazyAirRequestDTO crazyAirRequestDTO = new CrazyAirRequestDTO();
        busyFlightToCrazyAirRequestMapper.map(busyFlightsRequestDTO, crazyAirRequestDTO);

        assertEquals(busyFlightsRequestDTO.getDepartureDate(), crazyAirRequestDTO.getDepartureDate());
        assertEquals(busyFlightsRequestDTO.getReturnDate(), crazyAirRequestDTO.getReturnDate());
        assertEquals(busyFlightsRequestDTO.getOrigin(), crazyAirRequestDTO.getOrigin());
        assertEquals(busyFlightsRequestDTO.getDestination(), crazyAirRequestDTO.getDestination());
        assertEquals(busyFlightsRequestDTO.getNumberOfPassengers(), crazyAirRequestDTO.getNumberOfPassengers());
    }

    @Test
    public void busyFlightToToughJetRequest(){
        BusyFlightsRequestDTO busyFlightsRequestDTO = new BusyFlightsRequestDTO();
        busyFlightsRequestDTO.setDepartureDate(DateHelpers.getStringDateISO8601(2017,10,9));
        busyFlightsRequestDTO.setReturnDate(DateHelpers.getStringDateISO8601(2017,10,17));
        busyFlightsRequestDTO.setOrigin("SVQ");
        busyFlightsRequestDTO.setDestination("STN");
        busyFlightsRequestDTO.setNumberOfPassengers(1);


        BusyFlightToToughJetRequestMapper busyFlightToToughJetRequestMapper = new BusyFlightToToughJetRequestMapper();
        ToughJetRequestDTO toughJetRequestDTO = new ToughJetRequestDTO();
        busyFlightToToughJetRequestMapper.map(busyFlightsRequestDTO, toughJetRequestDTO);

        String departureDate = DateHelpers.getStringDateISO8601(toughJetRequestDTO.getDepartureYear(), toughJetRequestDTO.getDepartureMonth(), toughJetRequestDTO.getDepartureDay());
        String returnDate = DateHelpers.getStringDateISO8601(toughJetRequestDTO.getReturnYear(), toughJetRequestDTO.getReturnMonth(), toughJetRequestDTO.getReturnDay());

        assertEquals(busyFlightsRequestDTO.getDepartureDate(), departureDate);
        assertEquals(busyFlightsRequestDTO.getReturnDate(), returnDate);
        assertEquals(busyFlightsRequestDTO.getOrigin(), toughJetRequestDTO.getFrom());
        assertEquals(busyFlightsRequestDTO.getDestination(), toughJetRequestDTO.getTo());
        assertEquals(busyFlightsRequestDTO.getNumberOfPassengers(), toughJetRequestDTO.getNumberOfAdults());
    }

}
