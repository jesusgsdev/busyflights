package com.jesusgsdev.mappings.custom;

import com.jesusgsdev.suppliers.Supplier;
import com.jesusgsdev.busyflights.dto.BusyFlightsResponseDTO;
import com.jesusgsdev.suppliers.crazyair.dto.CrazyAirResponseDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

/**
 * Created by jesgarsal on 29/01/17.
 */
@Component
public class CrazyAirToBusyFlightResponseCustomMapper extends CustomMapper<CrazyAirResponseDTO, BusyFlightsResponseDTO> {

    @Override
    public void mapAtoB(CrazyAirResponseDTO a, BusyFlightsResponseDTO b, MappingContext context) {
        //Date from mm-dd-yyyy HH:MM:ss to ISO8601 format

        b.setSupplier(Supplier.CRAZY_AIR);
    }


}
