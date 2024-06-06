package club_nautico.controller;


import club_nautico.entity.Salida;
import club_nautico.exception.DuplicateException;
import club_nautico.exception.NotFoundException;
import club_nautico.service.SalidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class SalidaController {
    @Autowired
    SalidaService salidaService;

    @GetMapping("/findAllSalidas")
    public ResponseEntity<List<Salida>> findAllSalidas(){
        return ResponseEntity.status(HttpStatus.OK).body(salidaService.findAllSalidas());
    }

    @GetMapping("/findSalidaById/{id_salida}")
    public ResponseEntity<Salida> findSalidaById(@PathVariable Integer id_salida) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(salidaService.findSalidaById(id_salida));}

    @PostMapping("/saveSalida")
    public ResponseEntity<Salida> saveSalida(@RequestBody Salida salida) throws DuplicateException, NotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(salidaService.saveSalida(salida));
    }

    @PutMapping("/updateSalida/{id}")
    public ResponseEntity<Salida> updateSalida(@PathVariable Integer id,@RequestBody Salida salida) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(salidaService.updateSalida(id, salida));
    }

    @DeleteMapping("/deleteSalida/{id}")
    public ResponseEntity<Salida> deleteSalida(@PathVariable Integer id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(salidaService.deleteSalida(id));
    }

}
