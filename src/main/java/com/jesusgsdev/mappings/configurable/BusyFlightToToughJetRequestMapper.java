package com.jesusgsdev.mappings.configurable;

import com.jesusgsdev.busyflights.dto.BusyFlightsRequestDTO;
import com.jesusgsdev.mappings.custom.BusyFlightToToughJetCustomMapper;
import com.jesusgsdev.suppliers.toughjet.dto.ToughJetRequestDTO;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

/**
 * Created by jesgarsal on 29/01/17.
 */

public class BusyFlightToToughJetRequestMapper extends ConfigurableMapper{

    protected void configure(MapperFactory factory){
        factory.classMap(BusyFlightsRequestDTO.class, ToughJetRequestDTO.class)
               .field("origin", "from")
               .field("destination", "to")
               .field("numberOfPassengers", "numberOfAdults")
               .customize(new BusyFlightToToughJetCustomMapper()).byDefault()
               .register();
   }

}
