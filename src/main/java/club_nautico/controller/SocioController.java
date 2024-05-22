package club_nautico.controller;


import club_nautico.entity.Socio;
import club_nautico.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
