package club_nautico.service;

import club_nautico.entity.Barco;
import club_nautico.repository.BarcoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BarcoServiceImpl implements BarcoService{
    @Autowired
    BarcoRepository barcoRepository;

    @Override
    public List<Barco> findAllBarcos(){

        return barcoRepository.findAll();
    }

    @Override
    public Barco saveBarco(Barco barco) {
        return null;
    }
}
