package com.jesusgsdev.suppliers.crazyair.services;

import com.jesusgsdev.suppliers.crazyair.database.InMemoryDataCrazyAIr;
import com.jesusgsdev.suppliers.crazyair.dto.CrazyAirRequestDTO;
import com.jesusgsdev.suppliers.crazyair.dto.CrazyAirResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jesgarsal on 29/01/17.
 */
@Service
public class CrazyAirService {

    @Autowired
    InMemoryDataCrazyAIr inMemoryDataCrazyAir;

    public List<CrazyAirResponseDTO> search(CrazyAirRequestDTO crazyAirRequestDTO ){
        List<CrazyAirResponseDTO> response =
                inMemoryDataCrazyAir.database.stream()
                .filter(r -> r.getDepartureDate().equals(crazyAirRequestDTO.getDepartureDate()))
                .filter(r -> r.getArrivalDate().equals(crazyAirRequestDTO.getReturnDate()))
                .filter(r -> r.getDepartureAirportCode().equals(crazyAirRequestDTO.getOrigin()))
                .filter(r -> r.getDestinationAirportCode().equals(crazyAirRequestDTO.getDestination()))
                .collect(Collectors.toList());

        return  response;
    }

}
