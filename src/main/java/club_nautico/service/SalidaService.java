package club_nautico.service;


import club_nautico.entity.Salida;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface SalidaService {
    List<Salida> findAllSalidas();
    Optional<Salida> findSalidaById(int id_salida);
    Salida saveSalida(Salida salida);
    Salida updateSalida(Integer id,Salida salida);
    String deleteSalida(Integer id);
}