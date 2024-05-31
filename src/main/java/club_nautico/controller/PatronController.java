package club_nautico.controller;


import club_nautico.entity.Patron;
import club_nautico.exception.DuplicateException;
import club_nautico.exception.NotFoundException;
import club_nautico.service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class PatronController {
    @Autowired
    PatronService patronService;

    @GetMapping("/findAllPatrones")
    public List<Patron> findAllPatrones() {
        return patronService.findAllPatrones();
    }

    @GetMapping("/findPatronById/{id_patron}")
    public Patron findPatronById(@PathVariable Integer id_patron) throws NotFoundException {return patronService.findPatronById(id_patron);}

    @PostMapping("/savePatron")
    public Patron savePatron(@RequestBody Patron patron) throws DuplicateException, NotFoundException{
        return patronService.savePatron(patron);
    }

    @PutMapping("/updatePatron/{id}")
    public Patron updatePatron( @PathVariable Integer id, @RequestBody Patron patron) throws NotFoundException {
        return patronService.updatePatron(id, patron);
    }

    @DeleteMapping("/deletePatron/{id}")
    public String deletePatron(@PathVariable Integer id) throws NotFoundException {
        patronService.deletePatron(id);
        return "El patron se ha borrado correctamente";
    }
}