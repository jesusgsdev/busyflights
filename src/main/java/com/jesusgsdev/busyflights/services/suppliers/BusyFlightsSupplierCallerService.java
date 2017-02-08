package com.jesusgsdev.busyflights.services.suppliers;

import com.jesusgsdev.busyflights.dto.BusyFlightsResponseDTO;
import com.jesusgsdev.busyflights.dto.BusyFlightsRequestDTO;

import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by jesgarsal on 02/02/17.
 */
public interface BusyFlightsSupplierCallerService {

    Future<List<BusyFlightsResponseDTO>> search(BusyFlightsRequestDTO busyFlightsRequestDTO) throws InterruptedException;

}
