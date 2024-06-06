package club_nautico.controller;


import club_nautico.entity.Socio;
import club_nautico.exception.DuplicateException;
import club_nautico.exception.NotFoundException;
import club_nautico.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController

public class SocioController {
    @Autowired
    private SocioService socioService;


    @GetMapping("/findAllSocios")
    public ResponseEntity<?> findAllSocios(){

        return ResponseEntity.status(HttpStatus.OK).body(socioService.findAllSocios());
    }

    @GetMapping("/findAllSocioBarcos/{socio_dni}")
    public ResponseEntity<?> findAllSocioBarcos(@PathVariable String socio_dni) throws NotFoundException{
        return ResponseEntity.status(HttpStatus.OK).body(socioService.findAllSocioBarcos(socio_dni));
    }
    @GetMapping("/findSocioById/{socio_dni}")
    public ResponseEntity<?> findSocioById(@PathVariable String socio_dni) throws NotFoundException{
        return ResponseEntity.status(HttpStatus.OK).body(socioService.findSocioById(socio_dni));
    }


    @PostMapping("/saveSocios")
    public ResponseEntity<?> saveSocio(@RequestBody Socio socio) throws DuplicateException {
        return ResponseEntity.status(HttpStatus.CREATED).body(socioService.saveSocio(socio));
    }

    @PutMapping("/updateSocios/{dni}")
    public ResponseEntity<?> updateSocio(@PathVariable String dni, @RequestBody Socio socio) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(socioService.updateSocio(dni, socio));
    }

    @DeleteMapping("/deleteSocios/{dni}")
    public String deleteSocio(@PathVariable String dni) throws NotFoundException {
        ResponseEntity.status(HttpStatus.NO_CONTENT).body(socioService.deleteSocio(dni));
        return "Socio borrado con éxito";
    }
}
