package com.jesusgsdev.suppliers.crazyair.controller;

import com.jesusgsdev.suppliers.Supplier;
import com.jesusgsdev.suppliers.crazyair.dto.CrazyAirRequestDTO;
import com.jesusgsdev.suppliers.crazyair.dto.CrazyAirResponseDTO;
import com.jesusgsdev.suppliers.crazyair.services.CrazyAirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/crazy-air")
@RestController
public class CrazyAirController {

    @Autowired
    private CrazyAirService crazyAirService;

    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    @ResponseBody
    @Cacheable(Supplier.CRAZY_AIR)
    public List<CrazyAirResponseDTO> search(@RequestBody final CrazyAirRequestDTO searchDTO) {
        return crazyAirService.search(searchDTO);
    }

}
