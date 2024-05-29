package club_nautico.controller;


import club_nautico.entity.Barco;
import club_nautico.entity.Patron;
import club_nautico.service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class PatronController {
    @Autowired
    PatronService patronService;

    @GetMapping("/findAllPatrones")
    public List<Patron> findAllPatrones() {
        return patronService.findAllPatrones();
    }

    @GetMapping("findBarcoById/{id_patron}")
    public Optional<Patron> findPatronById(@PathVariable Integer id_patron){return patronService.findPatronById(id_patron);}

    @PostMapping("/savePatron")
    public Patron savePatron(@RequestBody Patron patron) {
        return patronService.savePatron(patron);
    }

    @PutMapping("/updatePatron/{id}")
    public Patron updatePatron( Integer id, @RequestBody Patron patron) {
        return patronService.updatePatron(id, patron);
    }

    @DeleteMapping("/deletePatron/{id}")
    public String deletePatron(@PathVariable Integer id) {
        patronService.deletePatron(id);
        return "El patron se ha borrado correctamente";
    }
}