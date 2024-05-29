package club_nautico.controller;


import club_nautico.entity.Socio;
import club_nautico.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
