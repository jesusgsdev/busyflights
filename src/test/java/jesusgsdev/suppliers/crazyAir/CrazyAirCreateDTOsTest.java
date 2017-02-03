package jesusgsdev.suppliers.crazyAir;

import com.jesusgsdev.helpers.DateHelpers;
import com.jesusgsdev.suppliers.crazyair.dto.CrazyAirRequestDTO;
import com.jesusgsdev.suppliers.crazyair.dto.CrazyAirResponseDTO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jesgarsal on 02/02/17.
 */

public class CrazyAirCreateDTOsTest {

    @Test
    public void createCrazyAirRequestDTO(){
        CrazyAirRequestDTO crazyAirRequestDTO = new CrazyAirRequestDTO();
        crazyAirRequestDTO.setNumberOfPassengers(4);
        crazyAirRequestDTO.setOrigin("STN");
        crazyAirRequestDTO.setDestination("SVQ");
        crazyAirRequestDTO.setDepartureDate(DateHelpers.getStringDateISO8601(2018,1,1));
        crazyAirRequestDTO.setReturnDate(DateHelpers.getStringDateISO8601(2018,1,9));

        assertEquals(crazyAirRequestDTO.getNumberOfPassengers(), new Integer(4));
        assertEquals(crazyAirRequestDTO.getOrigin(), "STN");
        assertEquals(crazyAirRequestDTO.getDestination(), "SVQ");
        assertEquals(crazyAirRequestDTO.getDepartureDate(), DateHelpers.getStringDateISO8601(2018,1,1));
        assertEquals(crazyAirRequestDTO.getReturnDate(), DateHelpers.getStringDateISO8601(2018,1,9));
    }

    @Test
    public void createCrazyAirResponseDTO(){
        CrazyAirResponseDTO crazyAirResponseDTO = CrazyAirResponseDTO.newCrazyAirResponseDTO().airline("Ryanair")
                .departureAirportCode("STN")
                .destinationAirportCode("SVQ")
                .departureDate(DateHelpers.getStringDateISO8601(2018,1,1))
                .arrivalDate(DateHelpers.getStringDateISO8601(2018,1,9))
                .cabinclass("E")
                .price(180.50).build();

        assertEquals(crazyAirResponseDTO.getAirline(), "Ryanair");
        assertEquals(crazyAirResponseDTO.getDepartureAirportCode(), "STN");
        assertEquals(crazyAirResponseDTO.getDestinationAirportCode(), "SVQ");
        assertEquals(crazyAirResponseDTO.getDepartureDate(), DateHelpers.getStringDateISO8601(2018,1,1));
        assertEquals(crazyAirResponseDTO.getArrivalDate(), DateHelpers.getStringDateISO8601(2018,1,9));
        assertEquals(crazyAirResponseDTO.getCabinclass(), "E");
        assertEquals(crazyAirResponseDTO.getPrice(), new Double(180.50));
    }



}
