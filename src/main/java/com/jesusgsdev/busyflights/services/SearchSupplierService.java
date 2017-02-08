package com.jesusgsdev.busyflights.services;

import com.jesusgsdev.suppliers.Supplier;
import com.jesusgsdev.busyflights.dto.BusyFlightsResponseDTO;
import com.jesusgsdev.busyflights.dto.BusyFlightsRequestDTO;
import com.jesusgsdev.busyflights.services.suppliers.BusyFlightsCrazyAirCallerService;
import com.jesusgsdev.busyflights.services.suppliers.BusyFlightsToughJetCallerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;


/**
 * Created by jesgarsal on 02/02/17.
 */
@Service
public class SearchSupplierService {

    @Autowired
    BusyFlightsCrazyAirCallerService crazyAirCallerService;

    @Autowired
    BusyFlightsToughJetCallerService toughJetCallerService;

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchSupplierService.class);

    public Future<List<BusyFlightsResponseDTO>> search(BusyFlightsRequestDTO busyFlightsRequestDTO, String supplier){
        Future<List<BusyFlightsResponseDTO>> results = new AsyncResult<>(Collections.emptyList());
        try {
            switch (supplier){
                case Supplier.CRAZY_AIR:
                    results = crazyAirCallerService.search(busyFlightsRequestDTO);
                    break;
                case Supplier.TOUGH_JET:
                    results = toughJetCallerService.search(busyFlightsRequestDTO);
                    break;
            }
        } catch (InterruptedException e) {
            LOGGER.error(String.format("Error during searching with supplier %s", supplier), e);
        }
        return results;
    }

}
