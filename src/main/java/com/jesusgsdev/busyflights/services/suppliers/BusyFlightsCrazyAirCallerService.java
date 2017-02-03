package com.jesusgsdev.busyflights.services.suppliers;

import com.jesusgsdev.busyflights.dto.BusyFlightsResponseDTO;
import com.jesusgsdev.busyflights.dto.BusyFlightsSearchDTO;
import com.jesusgsdev.busyflights.services.BusyFlightsConverterService;
import com.jesusgsdev.suppliers.crazyair.dto.CrazyAirRequestDTO;
import com.jesusgsdev.suppliers.crazyair.dto.CrazyAirResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jesgarsal on 29/01/17.
 */
@Service
public class BusyFlightsCrazyAirCallerService implements BusyFlightsSupplierCallerService {

    @Value("${supplier.crazyair.url}")
    private String url;

    @Autowired
    private BusyFlightsConverterService busyFlightsConverterService;

    @Override
    @Async
    public Future<List<BusyFlightsResponseDTO>> search(BusyFlightsSearchDTO busyFlightsSearchDTO) throws InterruptedException {
        CrazyAirRequestDTO crazyAirRequestDTO = busyFlightsConverterService.getCrazyAirRequestDTO(busyFlightsSearchDTO);

        final RestTemplate restTemplate = new RestTemplate();

        CrazyAirResponseDTO[] crazyAirResponse = restTemplate.postForObject(url,crazyAirRequestDTO, CrazyAirResponseDTO[].class);

        List<BusyFlightsResponseDTO> busyFlightsResponseDTO = Stream.of(crazyAirResponse)
                                .map(r -> busyFlightsConverterService.getBusyFlightResponseDTO(r))
                                .collect(Collectors.toList());

        //Artificial delay
        Thread.sleep(1000L);

        return new AsyncResult<>(busyFlightsResponseDTO);
    }

}
