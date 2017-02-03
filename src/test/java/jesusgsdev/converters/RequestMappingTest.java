package jesusgsdev.converters;

import com.jesusgsdev.Application;
import com.jesusgsdev.busyflights.dto.BusyFlightsSearchDTO;
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
        BusyFlightsSearchDTO busyFlightsSearchDTO = new BusyFlightsSearchDTO();
        busyFlightsSearchDTO.setDepartureDate(DateHelpers.getStringDateISO8601(2017,10,9));
        busyFlightsSearchDTO.setReturnDate(DateHelpers.getStringDateISO8601(2017,10,17));
        busyFlightsSearchDTO.setOrigin("SVQ");
        busyFlightsSearchDTO.setDestination("STN");
        busyFlightsSearchDTO.setNumberOfPassengers(1);


        BusyFlightToCrazyAirRequestMapper busyFlightToCrazyAirRequestMapper = new BusyFlightToCrazyAirRequestMapper();
        CrazyAirRequestDTO crazyAirRequestDTO = new CrazyAirRequestDTO();
        busyFlightToCrazyAirRequestMapper.map(busyFlightsSearchDTO, crazyAirRequestDTO);

        assertEquals(busyFlightsSearchDTO.getDepartureDate(), crazyAirRequestDTO.getDepartureDate());
        assertEquals(busyFlightsSearchDTO.getReturnDate(), crazyAirRequestDTO.getReturnDate());
        assertEquals(busyFlightsSearchDTO.getOrigin(), crazyAirRequestDTO.getOrigin());
        assertEquals(busyFlightsSearchDTO.getDestination(), crazyAirRequestDTO.getDestination());
        assertEquals(busyFlightsSearchDTO.getNumberOfPassengers(), crazyAirRequestDTO.getNumberOfPassengers());
    }

    @Test
    public void busyFlightToToughJetRequest(){
        BusyFlightsSearchDTO busyFlightsSearchDTO = new BusyFlightsSearchDTO();
        busyFlightsSearchDTO.setDepartureDate(DateHelpers.getStringDateISO8601(2017,10,9));
        busyFlightsSearchDTO.setReturnDate(DateHelpers.getStringDateISO8601(2017,10,17));
        busyFlightsSearchDTO.setOrigin("SVQ");
        busyFlightsSearchDTO.setDestination("STN");
        busyFlightsSearchDTO.setNumberOfPassengers(1);


        BusyFlightToToughJetRequestMapper busyFlightToToughJetRequestMapper = new BusyFlightToToughJetRequestMapper();
        ToughJetRequestDTO toughJetRequestDTO = new ToughJetRequestDTO();
        busyFlightToToughJetRequestMapper.map(busyFlightsSearchDTO, toughJetRequestDTO);

        String departureDate = DateHelpers.getStringDateISO8601(toughJetRequestDTO.getDepartureYear(), toughJetRequestDTO.getDepartureMonth(), toughJetRequestDTO.getDepartureDay());
        String returnDate = DateHelpers.getStringDateISO8601(toughJetRequestDTO.getReturnYear(), toughJetRequestDTO.getReturnMonth(), toughJetRequestDTO.getReturnDay());

        assertEquals(busyFlightsSearchDTO.getDepartureDate(), departureDate);
        assertEquals(busyFlightsSearchDTO.getReturnDate(), returnDate);
        assertEquals(busyFlightsSearchDTO.getOrigin(), toughJetRequestDTO.getFrom());
        assertEquals(busyFlightsSearchDTO.getDestination(), toughJetRequestDTO.getTo());
        assertEquals(busyFlightsSearchDTO.getNumberOfPassengers(), toughJetRequestDTO.getNumberOfAdults());
    }

}
