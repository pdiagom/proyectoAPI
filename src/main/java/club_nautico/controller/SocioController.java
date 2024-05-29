package club_nautico.controller;


import club_nautico.entity.Socio;
import club_nautico.exception.DuplicateException;
import club_nautico.exception.NotFoundException;
import club_nautico.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class SocioController {
    @Autowired
    private SocioService socioService;


    @GetMapping("/findAllSocios")
    public List<Socio> findAllSocios(){

        return socioService.findAllSocios();
    }

    @GetMapping("/findSocioById/{socio_dni}")
    public Socio findSocioById(@PathVariable String socio_dni) throws NotFoundException{
        return socioService.findSocioById(socio_dni);
    }


    @PostMapping("/saveSocios")
    public Socio saveSocio(@RequestBody Socio socio) throws DuplicateException {
        return socioService.saveSocio(socio);
    }

    @PutMapping("/updateSocios/{dni}")
    public Socio updateSocio(@PathVariable String dni, @RequestBody Socio socio) throws NotFoundException {
        return socioService.updateSocio(dni,socio);
    }

    @DeleteMapping("/deleteSocios/{dni}")
    public String deleteSocio(@PathVariable String dni) throws NotFoundException {
        socioService.deleteSocio(dni);
        return "Socio borrado con éxito";
    }
}
