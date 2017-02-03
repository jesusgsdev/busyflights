package com.jesusgsdev.mappings.custom;

import com.jesusgsdev.busyflights.dto.BusyFlightsSearchDTO;
import com.jesusgsdev.helpers.DateHelpers;
import com.jesusgsdev.suppliers.toughjet.dto.ToughJetRequestDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by jesgarsal on 29/01/17.
 */
@Component
public class BusyFlightToToughJetCustomMapper extends CustomMapper<BusyFlightsSearchDTO, ToughJetRequestDTO> {

    @Override
    public void mapAtoB(BusyFlightsSearchDTO a, ToughJetRequestDTO b, MappingContext context) {
        LocalDate departureDate = DateHelpers.getLocalDateFromStringInISO8601(a.getDepartureDate());
        b.setDepartureDay(departureDate.getDayOfMonth());
        b.setDepartureMonth(departureDate.getMonthValue());
        b.setDepartureYear(departureDate.getYear());

        LocalDate returnDate = DateHelpers.getLocalDateFromStringInISO8601(a.getReturnDate());
        b.setReturnDay(returnDate.getDayOfMonth());
        b.setReturnMonth(returnDate.getMonthValue());
        b.setReturnYear(returnDate.getYear());
    }

}
