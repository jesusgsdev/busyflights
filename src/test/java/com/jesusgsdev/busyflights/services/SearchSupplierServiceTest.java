package com.jesusgsdev.busyflights.services;

import com.jesusgsdev.Application;
import com.jesusgsdev.busyflights.dto.BusyFlightsResponseDTO;
import com.jesusgsdev.busyflights.dto.BusyFlightsRequestDTO;
import com.jesusgsdev.busyflights.services.SearchSupplierService;
import com.jesusgsdev.helpers.DateHelpers;
import com.jesusgsdev.suppliers.Supplier;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by jesgarsal on 02/02/17.
 */
@ComponentScan
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SearchSupplierServiceTest {

    @Autowired
    SearchSupplierService searchFacade;

    @Test
    @Ignore
    public void crazyAirSearch() throws ExecutionException, InterruptedException {
        BusyFlightsRequestDTO busyFlightsRequestDTO = getBaseRequest();

        Future<List<BusyFlightsResponseDTO>> futureResults = searchFacade.search(busyFlightsRequestDTO, Supplier.CRAZY_AIR);
        while (!futureResults.isDone()) {
            Thread.sleep(10); //10-millisecond pause between each check
        }

        List<BusyFlightsResponseDTO> results = futureResults.get();

        Assert.notNull(results);
        Assert.notEmpty(results);
    }

    @Test
    @Ignore
    public void toughJetSearch() throws InterruptedException, ExecutionException {
        BusyFlightsRequestDTO busyFlightsRequestDTO = getBaseRequest();

        Future<List<BusyFlightsResponseDTO>> futureResults = searchFacade.search(busyFlightsRequestDTO, Supplier.TOUGH_JET);
        while (!futureResults.isDone()) {
            Thread.sleep(10); //10-millisecond pause between each check
        }
        List<BusyFlightsResponseDTO> results = futureResults.get();

        Assert.notNull(results);
        Assert.notEmpty(results);
    }

    private BusyFlightsRequestDTO getBaseRequest(){
        BusyFlightsRequestDTO busyFlightsRequestDTO = new BusyFlightsRequestDTO();
        busyFlightsRequestDTO.setDepartureDate(DateHelpers.getStringDateISO8601(2018,1,1));
        busyFlightsRequestDTO.setReturnDate(DateHelpers.getStringDateISO8601(2018,1,9));
        busyFlightsRequestDTO.setOrigin("STN");
        busyFlightsRequestDTO.setDestination("SVQ");
        busyFlightsRequestDTO.setNumberOfPassengers(1);

        return busyFlightsRequestDTO;
    }

}
