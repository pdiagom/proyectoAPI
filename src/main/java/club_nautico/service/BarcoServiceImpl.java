package club_nautico.service;

import club_nautico.entity.Barco;
import club_nautico.repository.BarcoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

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
        return barcoRepository.save(barco);
    }

    @Override
    public Barco updateBarco(String matricula, Barco barco) {
        Barco b=barcoRepository.findById(matricula).get();
        if(Objects.nonNull(barco.getNombre())&& !"".equalsIgnoreCase(barco.getNombre())){
            b.setNombre(barco.getNombre());
        }
        if(Objects.nonNull(barco.getAmarre())&& !"".equalsIgnoreCase(barco.getAmarre())){
            b.setAmarre(barco.getAmarre());

        }
        if(barco.getCuota()>0){
            b.setCuota(barco.getCuota());
        }


        return barcoRepository.save(b);
    }

    @Override
    public void deleteBarco(String matricula) {
        barcoRepository.deleteById(matricula);
    }
}
