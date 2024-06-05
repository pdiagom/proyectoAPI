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
    public List<Salida> findAllSalidas(){
        return salidaService.findAllSalidas();
    }

    @GetMapping("/findSalidaById/{id_salida}")
    public Salida findSalidaById(@PathVariable Integer id_salida) throws NotFoundException {return salidaService.findSalidaById(id_salida);}

    @PostMapping("/saveSalida")
    public ResponseEntity<?> saveSalida(@RequestBody Salida salida) throws DuplicateException {
        return ResponseEntity.status(HttpStatus.CREATED).body(salidaService.saveSalida(salida));
    }

    @PutMapping("/updateSalida/{id}")
    public Salida updateSalida(@PathVariable Integer id,@RequestBody Salida salida) throws NotFoundException {
        return salidaService.updateSalida(id, salida);
    }

    @DeleteMapping("/deleteSalida/{id}")
    public String deleteSalida(@PathVariable Integer id) throws NotFoundException {
        salidaService.deleteSalida(id);
        return "La salida se ha borrado correctamente";
    }

}
