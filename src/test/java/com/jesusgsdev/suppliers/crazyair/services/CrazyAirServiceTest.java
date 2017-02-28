package com.jesusgsdev.suppliers.crazyair.services;

import com.jesusgsdev.Application;
import com.jesusgsdev.busyflights.dto.BusyFlightsResponseDTO;
import com.jesusgsdev.busyflights.dto.BusyFlightsRequestDTO;
import com.jesusgsdev.busyflights.services.BusyFlightsConverterService;
import com.jesusgsdev.busyflights.services.suppliers.BusyFlightsCrazyAirCallerService;
import com.jesusgsdev.helpers.DateHelpers;
import com.jesusgsdev.suppliers.crazyair.dto.CrazyAirRequestDTO;
import com.jesusgsdev.suppliers.crazyair.dto.CrazyAirResponseDTO;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

/**
 * Created by jesgarsal on 02/02/17.
 */
@ComponentScan
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CrazyAirServiceTest {

    @Autowired
    private CrazyAirService crazyAirService;

    private CrazyAirRequestDTO crazyAirRequestDTO;

    @Before
    public void setUp() throws Exception {
        setUpCrazyAirRequest();
    }

    @Test
    public void crazyAirSearchTest() throws InterruptedException, ExecutionException {
        List<CrazyAirResponseDTO> crazyAirResponse = crazyAirService.search(crazyAirRequestDTO);

        Assert.notNull(crazyAirResponse);
        assertThat(crazyAirResponse, not(IsEmptyCollection.empty()));
        assertThat(crazyAirResponse, hasSize(2));
    }

    private void setUpCrazyAirRequest() {
        crazyAirRequestDTO =
                CrazyAirRequestDTO.newCrazyAirRequestDTO()
                        .numberOfPassengers(4)
                        .origin("STN")
                        .destination("SVQ")
                        .departureDate(DateHelpers.getStringDateISO8601(2018,1,1))
                        .returnDate(DateHelpers.getStringDateISO8601(2018,1,9))
                        .build();
    }

}
