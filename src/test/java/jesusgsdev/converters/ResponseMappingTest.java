package jesusgsdev.converters;

import com.jesusgsdev.Application;
import com.jesusgsdev.suppliers.Supplier;
import com.jesusgsdev.busyflights.dto.BusyFlightsResponseDTO;
import com.jesusgsdev.helpers.DateHelpers;
import com.jesusgsdev.mappings.configurable.CrazyAirToBusyFlightResponseMapper;
import com.jesusgsdev.mappings.configurable.ToughJetToBusyFlightResponseMapper;
import com.jesusgsdev.suppliers.crazyair.dto.CrazyAirResponseDTO;
import com.jesusgsdev.suppliers.toughjet.dto.ToughJetResponseDTO;
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
public class ResponseMappingTest {

    @Test
    public void crazyAirToBusyFlightResponse(){
        CrazyAirResponseDTO crazyAirResponseDTO = CrazyAirResponseDTO.newCrazyAirResponseDTO().airline("Ryanair")
                .departureAirportCode("LHR").destinationAirportCode("SVQ")
                .departureDate("01-02-2018").arrivalDate("09-01-2018")
                .cabinclass("E").price(180.50).build();

        BusyFlightsResponseDTO busyFlightsResponseDTO = new BusyFlightsResponseDTO();

        CrazyAirToBusyFlightResponseMapper crazyAirToBusyFlightResponseMapper = new CrazyAirToBusyFlightResponseMapper();
        crazyAirToBusyFlightResponseMapper.map(crazyAirResponseDTO, busyFlightsResponseDTO);

        assertEquals(crazyAirResponseDTO.getAirline(), busyFlightsResponseDTO.getAirline());
        assertEquals(crazyAirResponseDTO.getDepartureDate(), busyFlightsResponseDTO.getDepartureDate());
        assertEquals(crazyAirResponseDTO.getArrivalDate(), busyFlightsResponseDTO.getArrivalDate());
        assertEquals(crazyAirResponseDTO.getDepartureAirportCode(), busyFlightsResponseDTO.getDepartureAirportCode());
        assertEquals(crazyAirResponseDTO.getDestinationAirportCode(), busyFlightsResponseDTO.getDestinationAirportCode());
        assertEquals(Supplier.CRAZY_AIR, busyFlightsResponseDTO.getSupplier());

    }

    @Test
    public void toughJetToBusyFlightResponse(){
        ToughJetResponseDTO toughJetResponseDTO =
                ToughJetResponseDTO.newToughJetResponseDTO().carrier("Ryanair")
                .basePrice(100.00).tax(20.0).discount(5.0)
                .departureAirportName("LHR").arrivalAirportName("SVQ")
                .departureDay(1).departureMonth(2).departureYear(2018)
                .returnDay(10).returnMonth(2).returnYear(2018)
                .build();

        BusyFlightsResponseDTO busyFlightsResponseDTO = new BusyFlightsResponseDTO();

        ToughJetToBusyFlightResponseMapper toughJetToBusyFlightResponseMapper = new ToughJetToBusyFlightResponseMapper();
        toughJetToBusyFlightResponseMapper.map(toughJetResponseDTO, busyFlightsResponseDTO);

        Double tax = toughJetResponseDTO.getTax();
        Double basePrice = toughJetResponseDTO.getBasePrice();
        Double discount = toughJetResponseDTO.getDiscount();

        Double discountedPrice = toughJetResponseDTO.getDiscount() != 0.0 ? basePrice * (1.0 - discount) : basePrice;
        Double totalPrice = discountedPrice + tax;

        String departureDate = DateHelpers.getStringDateISO8601(toughJetResponseDTO.getDepartureYear(), toughJetResponseDTO.getDepartureMonth(), toughJetResponseDTO.getDepartureDay());
        String arrivalDate = DateHelpers.getStringDateISO8601(toughJetResponseDTO.getReturnYear(), toughJetResponseDTO.getReturnMonth(), toughJetResponseDTO.getReturnDay());

        assertEquals(toughJetResponseDTO.getCarrier(), busyFlightsResponseDTO.getAirline());
        assertEquals(departureDate, busyFlightsResponseDTO.getDepartureDate());
        assertEquals(arrivalDate, busyFlightsResponseDTO.getArrivalDate());
        assertEquals(toughJetResponseDTO.getDepartureAirportName(), busyFlightsResponseDTO.getDepartureAirportCode());
        assertEquals(toughJetResponseDTO.getArrivalAirportName(), busyFlightsResponseDTO.getDestinationAirportCode());
        assertEquals(totalPrice, busyFlightsResponseDTO.getFare());
        assertEquals(Supplier.TOUGH_JET, busyFlightsResponseDTO.getSupplier());

    }

}
