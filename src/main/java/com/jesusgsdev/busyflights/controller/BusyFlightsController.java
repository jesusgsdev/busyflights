package com.jesusgsdev.busyflights.controller;

import com.jesusgsdev.busyflights.dto.BusyFlightsResponseDTO;
import com.jesusgsdev.busyflights.dto.BusyFlightsSearchDTO;
import com.jesusgsdev.busyflights.services.BusyFlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class BusyFlightsController {

    @Autowired
    private BusyFlightsService busyFlightsService;

    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public List<BusyFlightsResponseDTO> search(@Valid @RequestBody final BusyFlightsSearchDTO searchDTO, BindingResult result) throws ExecutionException, InterruptedException {
        if (result.hasErrors()) {
            return Collections.emptyList();
        }

        return busyFlightsService.search(searchDTO);
    }

}
