package club_nautico.service;

import club_nautico.entity.Barco;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BarcoService {
    List<Barco> findAllBarcos();
}
