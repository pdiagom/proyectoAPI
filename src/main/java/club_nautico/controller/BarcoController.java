package club_nautico.controller;

import club_nautico.entity.Barco;
import club_nautico.exception.DuplicateException;
import club_nautico.exception.NotFoundException;
import club_nautico.service.BarcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BarcoController {
    @Autowired
    BarcoService barcoService;

    @GetMapping("/findAllBarcos")
    public List<Barco> findAllBarcos(){
        return barcoService.findAllBarcos();
    }

    @GetMapping("/findBarcoById/{matricula}")
    public ResponseEntity<?> findBarcoById(@PathVariable String matricula) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(barcoService.findBarcoById(matricula));}

    @PostMapping("/saveBarco")
    public ResponseEntity<?> saveLocal(@RequestBody Barco barco) throws DuplicateException {
        return ResponseEntity.status(HttpStatus.CREATED).body(barcoService.saveBarco(barco));
    }
    @PutMapping("/updateBarco/{matricula}")
    public ResponseEntity<?> updateBarco(@PathVariable("matricula") String matricula, @RequestBody Barco barco) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(barcoService.updateBarco(matricula,barco));
    }

    @DeleteMapping("/deleteBarco/{matricula}")
    public String deleteBarco(@PathVariable("matricula")String matricula ) throws NotFoundException {
        ResponseEntity.status(HttpStatus.CREATED).body(barcoService.deleteBarco(matricula));
        return "El barco se ha eliminado correctamente";
    }
}
