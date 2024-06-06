package club_nautico.controller;


import club_nautico.entity.Barco;
import club_nautico.entity.Socio;
import club_nautico.exception.DuplicateException;
import club_nautico.exception.NotFoundException;
import club_nautico.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class SocioController {
    @Autowired
    private SocioService socioService;


    @GetMapping("/findAllSocios")
    public ResponseEntity<List<Socio>> findAllSocios(){

        return ResponseEntity.status(HttpStatus.OK).body(socioService.findAllSocios());
    }

    @GetMapping("/findAllSocioBarcos/{socio_dni}")
    public ResponseEntity<List<Barco>> findAllSocioBarcos(@PathVariable String socio_dni) throws NotFoundException{
        return ResponseEntity.status(HttpStatus.OK).body(socioService.findAllSocioBarcos(socio_dni));
    }
    @GetMapping("/findSocioById/{socio_dni}")
    public ResponseEntity<Socio> findSocioById(@PathVariable String socio_dni) throws NotFoundException{
        return ResponseEntity.status(HttpStatus.OK).body(socioService.findSocioById(socio_dni));
    }


    @PostMapping("/saveSocios")
    public ResponseEntity<Socio> saveSocio(@RequestBody Socio socio) throws DuplicateException {
        return ResponseEntity.status(HttpStatus.CREATED).body(socioService.saveSocio(socio));
    }

    @PutMapping("/updateSocios/{dni}")
    public ResponseEntity<Socio> updateSocio(@PathVariable String dni, @RequestBody Socio socio) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(socioService.updateSocio(dni, socio));
    }

    @DeleteMapping("/deleteSocios/{dni}")
    public ResponseEntity<Socio> deleteSocio(@PathVariable String dni) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(socioService.deleteSocio(dni));
    }
}
