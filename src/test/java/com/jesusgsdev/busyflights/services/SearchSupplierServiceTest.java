package com.jesusgsdev.busyflights.services;

import com.jesusgsdev.Application;
import com.jesusgsdev.busyflights.dto.BusyFlightsRequestDTO;
import com.jesusgsdev.busyflights.dto.BusyFlightsResponseDTO;
import com.jesusgsdev.busyflights.services.suppliers.BusyFlightsCrazyAirCallerService;
import com.jesusgsdev.busyflights.services.suppliers.BusyFlightsToughJetCallerService;
import com.jesusgsdev.helpers.DateHelpers;
import com.jesusgsdev.suppliers.Supplier;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

/**
 * Created by jesgarsal on 02/02/17.
 */
@ComponentScan
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SearchSupplierServiceTest {

    private BusyFlightsRequestDTO busyFlightsRequestDTO;

    @Autowired
    private SearchSupplierService engine;

    @MockBean
    private BusyFlightsCrazyAirCallerService crazyAirCallerService;

    @MockBean
    private BusyFlightsToughJetCallerService toughJetCallerService;

    @Before
    public void before() throws InterruptedException {
        setupRequest();
        mockCrazyAirCallerService();
        mockToughJetCallerService();
    }

    @Test
    public void crazyAirSearch() throws ExecutionException, InterruptedException {
        Future<List<BusyFlightsResponseDTO>> futureResults = engine.search(busyFlightsRequestDTO, Supplier.CRAZY_AIR);
        while (!futureResults.isDone()) {
            Thread.sleep(10); //10-millisecond pause between each check
        }

        List<BusyFlightsResponseDTO> results = futureResults.get();

        Assert.notNull(results);
        assertThat(results, not(IsEmptyCollection.empty()));
        assertThat(results, hasSize(1));
    }

    @Test
    public void toughJetSearch() throws InterruptedException, ExecutionException {
        Future<List<BusyFlightsResponseDTO>> futureResults = engine.search(busyFlightsRequestDTO, Supplier.TOUGH_JET);
        while (!futureResults.isDone()) {
            Thread.sleep(10); //10-millisecond pause between each check
        }
        List<BusyFlightsResponseDTO> results = futureResults.get();

        Assert.notNull(results);
        assertThat(results, not(IsEmptyCollection.empty()));
        assertThat(results, hasSize(1));
    }

    private void mockToughJetCallerService() throws InterruptedException {
        Future<List<BusyFlightsResponseDTO>> toughJetResponse = generateToughJetResponse();
        given(this.toughJetCallerService.search(any())).willReturn(toughJetResponse);
    }


    private void mockCrazyAirCallerService() throws InterruptedException {
        Future<List<BusyFlightsResponseDTO>> crazyAirResponse = generateCrazyAirResponse();
        given(this.crazyAirCallerService.search(any())).willReturn(crazyAirResponse);
    }

    private Future<List<BusyFlightsResponseDTO>> generateToughJetResponse() {
        List<BusyFlightsResponseDTO> busyFlightsResponseDTO = new LinkedList<>();

        busyFlightsResponseDTO.add(BusyFlightsResponseDTO.newBusyFlightsResponseDTO()
                .airline("Ryanair")
                .departureAirportCode("STN")
                .destinationAirportCode("SVQ")
                .departureDate(DateHelpers.getStringDateISO8601(2018,1,1))
                .arrivalDate(DateHelpers.getStringDateISO8601(2018,1,9))
                .fare(200.0)
                .supplier(Supplier.TOUGH_JET)
                .build());

        return new AsyncResult<>(busyFlightsResponseDTO);
    }

    private Future<List<BusyFlightsResponseDTO>> generateCrazyAirResponse() {
        List<BusyFlightsResponseDTO> busyFlightsResponseDTO = new LinkedList<>();

        busyFlightsResponseDTO.add(BusyFlightsResponseDTO.newBusyFlightsResponseDTO()
                .airline("Ryanair")
                .departureAirportCode("STN")
                .destinationAirportCode("SVQ")
                .departureDate(DateHelpers.getStringDateISO8601(2018,1,1))
                .arrivalDate(DateHelpers.getStringDateISO8601(2018,1,9))
                .fare(180.50)
                .supplier(Supplier.CRAZY_AIR)
                .build());

        return new AsyncResult<>(busyFlightsResponseDTO);
    }

    private void setupRequest() {
        busyFlightsRequestDTO = new BusyFlightsRequestDTO();
        busyFlightsRequestDTO.setDepartureDate(DateHelpers.getStringDateISO8601(2018,1,1));
        busyFlightsRequestDTO.setReturnDate(DateHelpers.getStringDateISO8601(2018,1,9));
        busyFlightsRequestDTO.setOrigin("STN");
        busyFlightsRequestDTO.setDestination("SVQ");
        busyFlightsRequestDTO.setNumberOfPassengers(1);
    }

}
