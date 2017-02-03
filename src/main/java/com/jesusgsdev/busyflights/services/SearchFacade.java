package com.jesusgsdev.busyflights.services;

import com.jesusgsdev.suppliers.Supplier;
import com.jesusgsdev.busyflights.dto.BusyFlightsResponseDTO;
import com.jesusgsdev.busyflights.dto.BusyFlightsSearchDTO;
import com.jesusgsdev.busyflights.services.suppliers.BusyFlightsCrazyAirCallerService;
import com.jesusgsdev.busyflights.services.suppliers.BusyFlightsToughJetCallerService;
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
public class SearchFacade {

    @Autowired
    BusyFlightsCrazyAirCallerService crazyAirCallerService;

    @Autowired
    BusyFlightsToughJetCallerService toughJetCallerService;

    public Future<List<BusyFlightsResponseDTO>> search(BusyFlightsSearchDTO busyFlightsSearchDTO, String supplier){
        Future<List<BusyFlightsResponseDTO>> results = new AsyncResult<>(Collections.emptyList());;
        try {
            switch (supplier){
                case Supplier.CRAZY_AIR:
                    results = crazyAirCallerService.search(busyFlightsSearchDTO);
                    break;
                case Supplier.TOUGH_JET:
                    results = toughJetCallerService.search(busyFlightsSearchDTO);
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return results;
    }

}
