package com.jesusgsdev.suppliers.toughjet.services;

import com.jesusgsdev.suppliers.Supplier;
import com.jesusgsdev.suppliers.toughjet.database.InMemoryDataToughJet;
import com.jesusgsdev.suppliers.toughjet.dto.ToughJetRequestDTO;
import com.jesusgsdev.suppliers.toughjet.dto.ToughJetResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jesgarsal on 29/01/17.
 */
@Service
public class ToughJetService {

    @Autowired
    InMemoryDataToughJet inMemoryDataToughJet;

    public List<ToughJetResponseDTO> search(ToughJetRequestDTO toughJetRequestDTO ){
        List<ToughJetResponseDTO> response =
                inMemoryDataToughJet.database.stream()
                        .filter(r -> r.getDepartureAirportName().equals(toughJetRequestDTO.getFrom()))
                        .filter(r -> r.getArrivalAirportName().equals(toughJetRequestDTO.getTo()))
                        .filter(r -> r.getDepartureDay().equals(toughJetRequestDTO.getDepartureDay()))
                        .filter(r -> r.getDepartureMonth().equals(toughJetRequestDTO.getDepartureMonth()))
                        .filter(r -> r.getDepartureYear().equals(toughJetRequestDTO.getDepartureYear()))
                        .filter(r -> r.getReturnDay().equals(toughJetRequestDTO.getReturnDay()))
                        .filter(r -> r.getReturnMonth().equals(toughJetRequestDTO.getReturnMonth()))
                        .filter(r -> r.getReturnYear().equals(toughJetRequestDTO.getReturnYear()))
                        .collect(Collectors.toList());

        return  response;
    }

}
