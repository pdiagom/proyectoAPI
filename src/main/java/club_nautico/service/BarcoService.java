package club_nautico.service;

import club_nautico.entity.Barco;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BarcoService {
    List<Barco> findAllBarcos();
    Optional<Barco> findBarcoById(String matricula);
    Barco saveBarco(Barco barco);
    Barco updateBarco(String matricula, Barco barco);
    String deleteBarco(String matricula);
}
