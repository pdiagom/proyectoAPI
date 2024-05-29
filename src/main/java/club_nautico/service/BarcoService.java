package club_nautico.service;

import club_nautico.entity.Barco;
import club_nautico.exception.DuplicateException;
import club_nautico.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BarcoService {
    List<Barco> findAllBarcos();
    Barco findBarcoById(String matricula) throws NotFoundException;
    Barco saveBarco(Barco barco) throws DuplicateException;
    Barco updateBarco(String matricula, Barco barco);
    String deleteBarco(String matricula) throws NotFoundException;
}
