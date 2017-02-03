package com.jesusgsdev.mappings.configurable;

import com.jesusgsdev.busyflights.dto.BusyFlightsResponseDTO;
import com.jesusgsdev.mappings.custom.ToughJetToBusyFlightResponseCustomMapper;
import com.jesusgsdev.suppliers.toughjet.dto.ToughJetResponseDTO;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

/**
 * Created by jesgarsal on 29/01/17.
 */

public class ToughJetToBusyFlightResponseMapper extends ConfigurableMapper{

    protected void configure(MapperFactory factory){
        factory.classMap(ToughJetResponseDTO.class, BusyFlightsResponseDTO.class)
               .field("carrier", "airline")
               .field("departureAirportName", "departureAirportCode")
               .field("arrivalAirportName", "destinationAirportCode")
               .customize(new ToughJetToBusyFlightResponseCustomMapper())
               .byDefault()
               .register();
   }

}
