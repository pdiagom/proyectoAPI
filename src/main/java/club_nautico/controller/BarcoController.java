package club_nautico.controller;

import club_nautico.entity.Barco;
import club_nautico.exception.DuplicateException;
import club_nautico.exception.NotFoundException;
import club_nautico.service.BarcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BarcoController {
    @Autowired
    BarcoService barcoService;

    @GetMapping("/findAllBarcos")
    public List<Barco> findAllBarcos(){
        return barcoService.findAllBarcos();
    }

    @GetMapping("/findBarcoById/{matricula}")
    public Barco findBarcoById(@PathVariable String matricula) throws NotFoundException {return barcoService.findBarcoById(matricula);}

    @PostMapping("/saveBarco")
    public Barco saveLocal(@RequestBody Barco barco) throws DuplicateException {
        return barcoService.saveBarco(barco);
    }
    @PutMapping("/updateBarco/{matricula}")
    public Barco updateBarco(@PathVariable("matricula") String matricula, @RequestBody Barco barco){
        return barcoService.updateBarco(matricula,barco);
    }

    @DeleteMapping("/deleteBarco/{matricula}")
    public String deleteBarco(@PathVariable("matricula")String matricula ){
    barcoService.deleteBarco(matricula);
    return "El barco se ha eliminado correctamente";
    }
}
