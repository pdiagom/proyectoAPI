package club_nautico.service;


import club_nautico.entity.Salida;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface SalidaService {
    List<Salida> findAllSalidas();
    Salida saveSalida(Salida salida);
    Salida updateSalida(Integer id,Salida salida);
    String deleteSalida(Integer id);
}