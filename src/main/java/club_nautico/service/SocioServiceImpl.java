package club_nautico.service;

import club_nautico.entity.Barco;
import club_nautico.entity.Socio;
import club_nautico.repository.BarcoRepository;
import club_nautico.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocioServiceImpl implements SocioService{
    @Autowired
    SocioRepository socioRepository;

    @Override
    public List<Socio> findAllSocios(){
        return socioRepository.findAll();
    }
}
