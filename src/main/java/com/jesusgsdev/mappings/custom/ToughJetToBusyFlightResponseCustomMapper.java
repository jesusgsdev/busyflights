package com.jesusgsdev.mappings.custom;

import com.jesusgsdev.suppliers.Supplier;
import com.jesusgsdev.busyflights.dto.BusyFlightsResponseDTO;
import com.jesusgsdev.helpers.DateHelpers;
import com.jesusgsdev.suppliers.toughjet.dto.ToughJetResponseDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

/**
 * Created by jesgarsal on 29/01/17.
 */
@Component
public class ToughJetToBusyFlightResponseCustomMapper extends CustomMapper<ToughJetResponseDTO, BusyFlightsResponseDTO> {

    @Override
    public void mapAtoB(ToughJetResponseDTO a, BusyFlightsResponseDTO b, MappingContext context) {
        //Date from year,month,day to ISO8601 format

        Double tax = a.getTax();
        Double basePrice = a.getBasePrice();
        Double discount = a.getDiscount();

        Double discountedPrice = a.getDiscount() != 0.0 ? basePrice * (1.0 - discount) : basePrice;

        b.setFare(discountedPrice + tax);

        String departureDateFormatted = DateHelpers.getStringDateISO8601(a.getDepartureYear(), a.getDepartureMonth(), a.getDepartureDay());
        String returnDateFormatted = DateHelpers.getStringDateISO8601(a.getReturnYear(), a.getReturnMonth(), a.getReturnDay());

        b.setDepartureDate(departureDateFormatted);
        b.setArrivalDate(returnDateFormatted);

        b.setSupplier(Supplier.TOUGH_JET);
    }


}
