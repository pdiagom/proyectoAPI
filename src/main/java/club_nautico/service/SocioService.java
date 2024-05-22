package club_nautico.service;

import club_nautico.entity.Socio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SocioService {
    List<Socio> findAllSocios();
//Hola
}
