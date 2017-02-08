package com.jesusgsdev.busyflights.services;

import com.jesusgsdev.busyflights.dto.BusyFlightsResponseDTO;
import com.jesusgsdev.busyflights.dto.BusyFlightsRequestDTO;
import com.jesusgsdev.mappings.configurable.BusyFlightToCrazyAirRequestMapper;
import com.jesusgsdev.mappings.configurable.BusyFlightToToughJetRequestMapper;
import com.jesusgsdev.mappings.configurable.CrazyAirToBusyFlightResponseMapper;
import com.jesusgsdev.mappings.configurable.ToughJetToBusyFlightResponseMapper;
import com.jesusgsdev.suppliers.crazyair.dto.CrazyAirRequestDTO;
import com.jesusgsdev.suppliers.crazyair.dto.CrazyAirResponseDTO;
import com.jesusgsdev.suppliers.toughjet.dto.ToughJetRequestDTO;
import com.jesusgsdev.suppliers.toughjet.dto.ToughJetResponseDTO;
import org.springframework.stereotype.Service;

/**
 * Created by jesgarsal on 29/01/17.
 */
@Service
public class BusyFlightsConverterService {

    public ToughJetRequestDTO getToughJetRequestDTO(BusyFlightsRequestDTO busyFlightsRequestDTO) {
        ToughJetRequestDTO toughJetRequestDTO = new ToughJetRequestDTO();
        BusyFlightToToughJetRequestMapper busyFlightToToughJetRequestMapper = new BusyFlightToToughJetRequestMapper();
        busyFlightToToughJetRequestMapper.map(busyFlightsRequestDTO, toughJetRequestDTO);

        return toughJetRequestDTO;
    }

    public CrazyAirRequestDTO getCrazyAirRequestDTO(BusyFlightsRequestDTO busyFlightsRequestDTO) {
        CrazyAirRequestDTO crazyAirRequestDTO = new CrazyAirRequestDTO();
        BusyFlightToCrazyAirRequestMapper busyFlightToCrazyAirRequestMapper = new BusyFlightToCrazyAirRequestMapper();
        busyFlightToCrazyAirRequestMapper.map(busyFlightsRequestDTO, crazyAirRequestDTO);

        return crazyAirRequestDTO;
    }

    public BusyFlightsResponseDTO getBusyFlightResponseDTO(ToughJetResponseDTO toughJetResponseDTO) {
        BusyFlightsResponseDTO busyFlightsResponseDTO = new BusyFlightsResponseDTO();
        ToughJetToBusyFlightResponseMapper toughJetToBusyFlightResponseMapper = new ToughJetToBusyFlightResponseMapper();
        toughJetToBusyFlightResponseMapper.map(toughJetResponseDTO, busyFlightsResponseDTO);

        return busyFlightsResponseDTO;
    }

    public BusyFlightsResponseDTO getBusyFlightResponseDTO(CrazyAirResponseDTO crazyAirResponseDTO) {
        BusyFlightsResponseDTO busyFlightsResponseDTO = new BusyFlightsResponseDTO();
        CrazyAirToBusyFlightResponseMapper crazyAirToBusyFlightResponseMapper = new CrazyAirToBusyFlightResponseMapper();
        crazyAirToBusyFlightResponseMapper.map(crazyAirResponseDTO, busyFlightsResponseDTO);

        return busyFlightsResponseDTO;
    }

}
