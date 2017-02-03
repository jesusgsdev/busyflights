package com.jesusgsdev.busyflights.services;

import com.jesusgsdev.suppliers.Supplier;
import com.jesusgsdev.busyflights.dto.BusyFlightsResponseDTO;
import com.jesusgsdev.busyflights.dto.BusyFlightsSearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


/**
 * Created by jesgarsal on 29/01/17.
 */
@Service
public class BusyFlightsService {

    @Autowired
    private SearchFacade searchFacade;

    public List<BusyFlightsResponseDTO> search(BusyFlightsSearchDTO busyFlightsSearchDTO) throws InterruptedException, ExecutionException {
        List<BusyFlightsResponseDTO> resultsCombined = new LinkedList<>();

        Future<List<BusyFlightsResponseDTO>> crazyAirResponse = searchFacade.search(busyFlightsSearchDTO, Supplier.CRAZY_AIR);
        Future<List<BusyFlightsResponseDTO>> toughJetResponse = searchFacade.search(busyFlightsSearchDTO, Supplier.TOUGH_JET);

        while (!(crazyAirResponse.isDone() && toughJetResponse.isDone())) {
            Thread.sleep(10); //10-millisecond pause between each check
        }

        resultsCombined.addAll(crazyAirResponse.get());
        resultsCombined.addAll(toughJetResponse.get());

        return resultsCombined;
    }

}
