package club_nautico.controller;

import club_nautico.entity.Socio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SocioController {
    private static final String template="Hola, %s";
    private final AtomicLong counter= new AtomicLong();

    @GetMapping("/socio")
    public Socio datosSocio(@RequestParam(value="name", defaultValue="Socio") String name){
        return new Socio(counter.incrementAndGet(), String.format(template,name));
    }

}
