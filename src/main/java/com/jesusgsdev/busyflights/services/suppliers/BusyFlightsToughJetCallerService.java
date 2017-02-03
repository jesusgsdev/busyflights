package com.jesusgsdev.busyflights.services.suppliers;

import com.jesusgsdev.busyflights.dto.BusyFlightsResponseDTO;
import com.jesusgsdev.busyflights.dto.BusyFlightsSearchDTO;
import com.jesusgsdev.busyflights.services.BusyFlightsConverterService;
import com.jesusgsdev.suppliers.toughjet.dto.ToughJetRequestDTO;
import com.jesusgsdev.suppliers.toughjet.dto.ToughJetResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class BusyFlightsToughJetCallerService implements BusyFlightsSupplierCallerService {

    @Value("${supplier.toughjet.url}")
    private String url;

    @Autowired
    private BusyFlightsConverterService busyFlightsConverterService;

    public Future<List<BusyFlightsResponseDTO>> search(BusyFlightsSearchDTO busyFlightsSearchDTO) throws InterruptedException {
        ToughJetRequestDTO toughJetRequestDTO = busyFlightsConverterService.getToughJetRequestDTO(busyFlightsSearchDTO);

        final RestTemplate restTemplate = new RestTemplate();

        ToughJetResponseDTO[] crazyAirResponse = restTemplate.postForObject(url, toughJetRequestDTO, ToughJetResponseDTO[].class);

        List<BusyFlightsResponseDTO> busyFlightsResponseDTO = Stream.of(crazyAirResponse)
                .map(r -> busyFlightsConverterService.getBusyFlightResponseDTO(r))
                .collect(Collectors.toList());

        //Artificial delay
        Thread.sleep(1000L);

        return new AsyncResult<>(busyFlightsResponseDTO);
    }

}
