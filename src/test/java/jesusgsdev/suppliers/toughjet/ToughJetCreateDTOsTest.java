package jesusgsdev.suppliers.toughjet;

import com.jesusgsdev.helpers.DateHelpers;
import com.jesusgsdev.suppliers.crazyair.dto.CrazyAirRequestDTO;
import com.jesusgsdev.suppliers.crazyair.dto.CrazyAirResponseDTO;
import com.jesusgsdev.suppliers.toughjet.dto.ToughJetRequestDTO;
import com.jesusgsdev.suppliers.toughjet.dto.ToughJetResponseDTO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jesgarsal on 02/02/17.
 */

public class ToughJetCreateDTOsTest {

    @Test
    public void createToughJetRequestDTO(){
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

        assertEquals(toughJetRequestDTO.getFrom(), "STN");
        assertEquals(toughJetRequestDTO.getTo(), "SVQ");
        assertEquals(toughJetRequestDTO.getDepartureDay(), new Integer(1));
        assertEquals(toughJetRequestDTO.getDepartureMonth(), new Integer(1));
        assertEquals(toughJetRequestDTO.getDepartureYear(), new Integer(2018));
        assertEquals(toughJetRequestDTO.getReturnDay(), new Integer(9));
        assertEquals(toughJetRequestDTO.getReturnMonth(), new Integer(1));
        assertEquals(toughJetRequestDTO.getReturnYear(), new Integer(2018));
    }

    @Test
    public void createToughJetResponseDTO(){
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



}
