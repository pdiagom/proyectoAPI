package com.eviden.pablo.api.clubNautico.Club.Nautico.controller;

import com.eviden.pablo.api.clubNautico.Club.Nautico.entity.Barco;
import com.eviden.pablo.api.clubNautico.Club.Nautico.service.BarcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BarcoController {
    @Autowired
    BarcoService barcoService;

    @GetMapping("/findAllBarcos")
    public List<Barco> findAllBarcos(){
        return barcoService.findAllBarcos();
    }
}
