package club_nautico.controller;


import club_nautico.entity.Patron;
import club_nautico.exception.DuplicateException;
import club_nautico.exception.NotFoundException;
import club_nautico.service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController

public class PatronController {
    @Autowired
    PatronService patronService;

    @GetMapping("/findAllPatrones")
    public ResponseEntity<?> findAllPatrones() {
        return ResponseEntity.status(HttpStatus.CREATED).body(patronService.findAllPatrones());
    }

    @GetMapping("/findPatronById/{id_patron}")
    public ResponseEntity<?> findPatronById(@PathVariable Integer id_patron) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(patronService.findPatronById(id_patron));}

    @PostMapping("/savePatron")
    public ResponseEntity<?> savePatron(@RequestBody Patron patron) throws DuplicateException, NotFoundException{
        return ResponseEntity.status(HttpStatus.CREATED).body(patronService.savePatron(patron));
    }

    @PutMapping("/updatePatron/{id}")
    public ResponseEntity<?> updatePatron( @PathVariable Integer id, @RequestBody Patron patron) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(patronService.updatePatron(id,patron));
    }

    @DeleteMapping("/deletePatron/{id}")
    public String deletePatron(@PathVariable Integer id) throws NotFoundException {
        ResponseEntity.status(HttpStatus.CREATED).body(patronService.deletePatron(id));
        return "El patron se ha borrado correctamente";
    }
}