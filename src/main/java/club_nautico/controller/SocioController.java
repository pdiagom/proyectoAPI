package club_nautico.controller;


import club_nautico.entity.Patron;
import club_nautico.entity.Socio;
import club_nautico.exception.NotFoundException;
import club_nautico.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController

public class SocioController {
    @Autowired
    private SocioService socioService;

    //private static final String template="Hola, %s";
    //private final AtomicLong counter= new AtomicLong();


    @GetMapping("/findAllSocios")
    public List<Socio> findAllSocios(){

        return socioService.findAllSocios();
    }

    @GetMapping("/findSocioById/{socio_dni}")
    public Socio findSocioById(@PathVariable String socio_dni) throws NotFoundException {return socioService.findSocioById(socio_dni);}

    @PostMapping("/saveSocios")
    public Socio saveSocio(@RequestBody Socio socio){
        return socioService.saveSocio(socio);
    }

    @PutMapping("/updateSocios/{dni}")
    public Socio updateSocio(@PathVariable String dni, @RequestBody Socio socio){
        return socioService.updateSocio(dni,socio);
    }

    @DeleteMapping("/deleteSocios/{dni}")
    public String deleteSocio(@PathVariable String dni){
        socioService.deleteSocio(dni);
        return "Socio borrado con éxito";
    }
}
