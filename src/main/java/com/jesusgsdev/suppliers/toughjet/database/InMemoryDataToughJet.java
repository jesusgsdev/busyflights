package com.jesusgsdev.suppliers.toughjet.database;

import com.jesusgsdev.suppliers.toughjet.dto.ToughJetResponseDTO;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jesgarsal on 29/01/17.
 */
@Component
public class InMemoryDataToughJet {

    public final List<ToughJetResponseDTO> database = new LinkedList<>();

    public InMemoryDataToughJet() {
        database.add(ToughJetResponseDTO.newToughJetResponseDTO().carrier("Ryanair")
                .basePrice(100.00).tax(20.0).discount(5.0)
                .departureAirportName("STN")
                .arrivalAirportName("SVQ")
                .departureDay(1).departureMonth(1).departureYear(2018)
                .returnDay(9).returnMonth(1).returnYear(2018)
                .build());
        database.add(ToughJetResponseDTO.newToughJetResponseDTO().carrier("Vueling")
                .basePrice(300.00).tax(35.0).discount(1.0)
                .departureAirportName("STN")
                .arrivalAirportName("SVQ")
                .departureDay(1).departureMonth(1).departureYear(2018)
                .returnDay(9).returnMonth(1).returnYear(2018)
                .build());
        database.add(ToughJetResponseDTO.newToughJetResponseDTO().carrier("British Airways")
                .basePrice(200.00).tax(40.0).discount(10.0)
                .departureAirportName("CCC").arrivalAirportName("DDD")
                .departureDay(1).departureMonth(4).departureYear(2018)
                .returnDay(11).returnMonth(4).returnYear(2018)
                .build());
    }
}
