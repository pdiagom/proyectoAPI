package club_nautico.controller;


import club_nautico.entity.Patron;
import club_nautico.exception.DuplicateException;
import club_nautico.exception.NotFoundException;
import club_nautico.service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class PatronController {
    @Autowired
    PatronService patronService;

    @GetMapping("/findAllPatrones")
    public ResponseEntity<List<Patron>> findAllPatrones() {
        return ResponseEntity.status(HttpStatus.OK).body(patronService.findAllPatrones());
    }

    @GetMapping("/findPatronById/{id_patron}")
    public ResponseEntity<Patron> findPatronById(@PathVariable Integer id_patron) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(patronService.findPatronById(id_patron));}

    @PostMapping("/savePatron")
    public ResponseEntity<Patron> savePatron(@RequestBody Patron patron) throws DuplicateException, NotFoundException{
        return ResponseEntity.status(HttpStatus.CREATED).body(patronService.savePatron(patron));
    }

    @PutMapping("/updatePatron/{id}")
    public ResponseEntity<Patron> updatePatron( @PathVariable Integer id, @RequestBody Patron patron) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(patronService.updatePatron(id,patron));
    }

    @DeleteMapping("/deletePatron/{id}")
    public ResponseEntity<Patron> deletePatron(@PathVariable Integer id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(patronService.deletePatron(id));
    }
}