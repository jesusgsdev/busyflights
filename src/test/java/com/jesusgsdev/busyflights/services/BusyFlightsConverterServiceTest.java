package com.jesusgsdev.busyflights.services;

import com.jesusgsdev.Application;
import com.jesusgsdev.busyflights.dto.BusyFlightsResponseDTO;
import com.jesusgsdev.busyflights.dto.BusyFlightsRequestDTO;
import com.jesusgsdev.helpers.DateHelpers;
import com.jesusgsdev.suppliers.crazyair.dto.CrazyAirRequestDTO;
import com.jesusgsdev.suppliers.crazyair.dto.CrazyAirResponseDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jesgarsal on 08/02/17.
 */
@ComponentScan
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BusyFlightsConverterServiceTest {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Autowired
    private BusyFlightsConverterService busyFlightsConverterService;


    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void crazyAirSearchTest() throws InterruptedException, ExecutionException {
        BusyFlightsRequestDTO busyFlightsRequestDTO = new BusyFlightsRequestDTO();
        busyFlightsRequestDTO.setDepartureDate(DateHelpers.getStringDateISO8601(2018,1,1));
        busyFlightsRequestDTO.setReturnDate(DateHelpers.getStringDateISO8601(2018,1,9));
        busyFlightsRequestDTO.setOrigin("STN");
        busyFlightsRequestDTO.setDestination("SVQ");
        busyFlightsRequestDTO.setNumberOfPassengers(1);

        CrazyAirRequestDTO crazyAirRequestDTO = busyFlightsConverterService.getCrazyAirRequestDTO(busyFlightsRequestDTO);

        CrazyAirResponseDTO[] crazyAirResponse = template.postForObject(base + "crazy-air/search", crazyAirRequestDTO, CrazyAirResponseDTO[].class);

        List<BusyFlightsResponseDTO> busyFlightsResponseDTO = Stream.of(crazyAirResponse)
                .map(r -> busyFlightsConverterService.getBusyFlightResponseDTO(r))
                .collect(Collectors.toList());

        Assert.notNull(busyFlightsResponseDTO);
        Assert.notEmpty(busyFlightsResponseDTO);
    }

}
