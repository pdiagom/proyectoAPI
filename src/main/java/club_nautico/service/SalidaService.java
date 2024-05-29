package club_nautico.service;


import club_nautico.entity.Salida;
import club_nautico.exception.DuplicateException;
import club_nautico.exception.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface SalidaService {
    List<Salida> findAllSalidas();
    Salida findSalidaById(int id_salida) throws NotFoundException;
    Salida saveSalida(Salida salida)throws DuplicateException;
    Salida updateSalida(Integer id,Salida salida)throws NotFoundException;
    String deleteSalida(Integer id) throws NotFoundException;
}