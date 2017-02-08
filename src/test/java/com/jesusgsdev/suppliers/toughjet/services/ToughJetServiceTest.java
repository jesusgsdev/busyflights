package com.jesusgsdev.suppliers.toughjet.services;

import com.jesusgsdev.Application;
import com.jesusgsdev.busyflights.dto.BusyFlightsResponseDTO;
import com.jesusgsdev.busyflights.dto.BusyFlightsRequestDTO;
import com.jesusgsdev.busyflights.services.BusyFlightsConverterService;
import com.jesusgsdev.busyflights.services.suppliers.BusyFlightsToughJetCallerService;
import com.jesusgsdev.helpers.DateHelpers;
import com.jesusgsdev.suppliers.toughjet.dto.ToughJetRequestDTO;
import com.jesusgsdev.suppliers.toughjet.dto.ToughJetResponseDTO;
import org.junit.Before;
import org.junit.Ignore;
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
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jesgarsal on 02/02/17.
 */
@ComponentScan
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ToughJetServiceTest {

    @Autowired
    BusyFlightsToughJetCallerService busyFlightToughJetCallerService;

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
    public void toughJetSearch() throws InterruptedException, ExecutionException {
        BusyFlightsRequestDTO busyFlightsRequestDTO = new BusyFlightsRequestDTO();
        busyFlightsRequestDTO.setDepartureDate(DateHelpers.getStringDateISO8601(2018,1,1));
        busyFlightsRequestDTO.setReturnDate(DateHelpers.getStringDateISO8601(2018,1,9));
        busyFlightsRequestDTO.setOrigin("STN");
        busyFlightsRequestDTO.setDestination("SVQ");
        busyFlightsRequestDTO.setNumberOfPassengers(1);

        ToughJetRequestDTO toughJetRequestDTO = busyFlightsConverterService.getToughJetRequestDTO(busyFlightsRequestDTO);

        ToughJetResponseDTO[] crazyAirResponse = template.postForObject(base + "tough-jet/search", toughJetRequestDTO, ToughJetResponseDTO[].class);

        List<BusyFlightsResponseDTO> busyFlightsResponseDTO = Stream.of(crazyAirResponse)
                .map(r -> busyFlightsConverterService.getBusyFlightResponseDTO(r))
                .collect(Collectors.toList());

        Assert.notNull(busyFlightsResponseDTO);
        Assert.notEmpty(busyFlightsResponseDTO);
    }

    @Test
    @Ignore
    public void toughJetSearch2() throws InterruptedException, ExecutionException {
        BusyFlightsRequestDTO busyFlightsRequestDTO = new BusyFlightsRequestDTO();
        busyFlightsRequestDTO.setDepartureDate(DateHelpers.getStringDateISO8601(2018,1,1));
        busyFlightsRequestDTO.setReturnDate(DateHelpers.getStringDateISO8601(2018,1,9));
        busyFlightsRequestDTO.setOrigin("STN");
        busyFlightsRequestDTO.setDestination("SVQ");
        busyFlightsRequestDTO.setNumberOfPassengers(1);

        Future<List<BusyFlightsResponseDTO>> futureResults = busyFlightToughJetCallerService.search(busyFlightsRequestDTO);
        while (!futureResults.isDone()) {
            Thread.sleep(10); //10-millisecond pause between each check
        }
        List<BusyFlightsResponseDTO> results = futureResults.get();

        Assert.notNull(results);
        Assert.notEmpty(results);
    }

}
