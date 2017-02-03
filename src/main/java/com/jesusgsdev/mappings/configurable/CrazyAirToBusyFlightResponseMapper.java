package com.jesusgsdev.mappings.configurable;

import com.jesusgsdev.busyflights.dto.BusyFlightsResponseDTO;
import com.jesusgsdev.mappings.custom.CrazyAirToBusyFlightResponseCustomMapper;
import com.jesusgsdev.suppliers.crazyair.dto.CrazyAirResponseDTO;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

/**
 * Created by jesgarsal on 29/01/17.
 */

public class CrazyAirToBusyFlightResponseMapper extends ConfigurableMapper{

   protected void configure(MapperFactory factory){
       factory.classMap(CrazyAirResponseDTO.class, BusyFlightsResponseDTO.class)
               .field("price","fare")
               .customize(new CrazyAirToBusyFlightResponseCustomMapper()).byDefault()
               .byDefault()
               .register();
   }

}
