package club_nautico.controller;

import club_nautico.entity.Barco;
import club_nautico.service.BarcoService;
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
