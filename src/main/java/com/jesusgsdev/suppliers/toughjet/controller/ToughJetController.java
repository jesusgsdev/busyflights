package com.jesusgsdev.suppliers.toughjet.controller;

import com.jesusgsdev.suppliers.Supplier;
import com.jesusgsdev.suppliers.toughjet.dto.ToughJetRequestDTO;
import com.jesusgsdev.suppliers.toughjet.dto.ToughJetResponseDTO;
import com.jesusgsdev.suppliers.toughjet.services.ToughJetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tough-jet")
@RestController
public class ToughJetController {

    @Autowired
    private ToughJetService toughJetService;

    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    @Cacheable(Supplier.TOUGH_JET)
    public List<ToughJetResponseDTO> search(@RequestBody final ToughJetRequestDTO searchDTO) {
        return toughJetService.search(searchDTO);
    }

}
