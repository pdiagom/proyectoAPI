package club_nautico.controller;


import club_nautico.entity.Salida;
import club_nautico.exception.NotFoundException;
import club_nautico.service.SalidaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Salida saveSalida(@RequestBody Salida salida){
        return salidaService.saveSalida(salida);
    }

    @PutMapping("/updateSalida/{id}")
    public Salida updateSalida(@PathVariable Integer id,@RequestBody Salida salida){
        return salidaService.updateSalida(id, salida);
    }

    @DeleteMapping("/deleteSalida/{id}")
    public String deleteSalida(@PathVariable Integer id) throws NotFoundException {
        salidaService.deleteSalida(id);
        return "La salida se ha borrado correctamente";
    }

}
