package club_nautico.service;

import club_nautico.entity.Barco;
import club_nautico.exception.DuplicateException;
import club_nautico.exception.NotFoundException;
import club_nautico.repository.BarcoRepository;
import club_nautico.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;


@Service
public class BarcoServiceImpl implements BarcoService{

    @Autowired
    BarcoRepository barcoRepository;

    @Autowired
    SocioRepository socioRepository;

    @Override
    public List<Barco> findAllBarcos(){

        return barcoRepository.findAll();
    }

    @Override
    public Barco findBarcoById(String matricula) throws NotFoundException {
        return barcoRepository.findById(matricula).orElseThrow(()-> new NotFoundException("Barco con matricula " + matricula + " no encontrado"));
    }

    @Override
    public Barco saveBarco(Barco barco) throws DuplicateException, NotFoundException {
        if(!socioRepository.existsById(barco.getSocio().getSocio_dni())){
            throw new NotFoundException("No existe socio con el dni: "+barco.getSocio().getSocio_dni());
        }else if(barcoRepository.existsById(barco.getMatricula())){
            throw new DuplicateException("El barco con matricula "+barco.getMatricula()+" ya esta registrado");
        }else {
            return barcoRepository.save(barco);
        }
    }

    @Override
    public Barco updateBarco(String matricula, Barco barco) throws NotFoundException {
        if(!barcoRepository.existsById(matricula)){
            throw new NotFoundException("Barco con matricula " + matricula + " no encontrado");
        }else {
            Barco barco_db = barcoRepository.findById(matricula).get();
            if (Objects.nonNull(barco.getNombre()) && !"".equalsIgnoreCase(barco.getNombre())) {
                barco_db.setNombre(barco.getNombre());
            }
            if (Objects.nonNull(barco.getAmarre()) && !"".equalsIgnoreCase(barco.getAmarre())) {
                barco_db.setAmarre(barco.getAmarre());

            }
            if (barco.getCuota() > 0) {
                barco_db.setCuota(barco.getCuota());
            }


            return barcoRepository.save(barco_db);
        }
    }

    @Override
    public Barco deleteBarco(String matricula) throws NotFoundException {
        Barco barco = barcoRepository.findById(matricula)
                .orElseThrow(() -> new NotFoundException("Barco no encontrado con matrícula: " + matricula));
        barcoRepository.deleteById(matricula);
        return barco;
    }
}
