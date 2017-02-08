package com.jesusgsdev.mappings.configurable;

import com.jesusgsdev.busyflights.dto.BusyFlightsRequestDTO;
import com.jesusgsdev.suppliers.crazyair.dto.CrazyAirRequestDTO;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

/**
 * Created by jesgarsal on 29/01/17.
 */

public class BusyFlightToCrazyAirRequestMapper extends ConfigurableMapper{

   protected void configure(MapperFactory factory){
       factory.classMap(BusyFlightsRequestDTO.class, CrazyAirRequestDTO.class)
               .byDefault()
               .register();
   }

}
