package club_nautico.service;


import club_nautico.entity.Salida;
import club_nautico.exception.DuplicateException;
import club_nautico.exception.NotFoundException;
import club_nautico.repository.BarcoRepository;
import club_nautico.repository.SalidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;


@Service
public class SalidaServiceImpl implements SalidaService{
    @Autowired
    SalidaRepository salidaRepository;

    @Autowired
    BarcoRepository barcoRepository;

    @Override
    public List<Salida> findAllSalidas() {return salidaRepository.findAll();}

    @Override
    public Salida findSalidaById(int id_salida) throws NotFoundException {
        return salidaRepository.findById(id_salida).orElseThrow(()-> new NotFoundException("Salida con id " + id_salida + " no encontrado"));
    }

    @Override
    public Salida saveSalida(Salida salida) throws DuplicateException, NotFoundException {
        boolean encontrado = salidaRepository.findAll().stream().anyMatch(s -> {
            if (Objects.nonNull(s.getBarco()) && Objects.nonNull(salida.getBarco())) {
                return s.getFecha_hora().equals(salida.getFecha_hora()) &&
                        s.getBarco().getMatricula().equals(salida.getBarco().getMatricula());
            } else {
                return false; // Si uno de los barcos es nulo, considerarlos distintos
            }
        });
        if(!barcoRepository.existsById(salida.getBarco().getMatricula())){
            throw new NotFoundException("No existe barco con matricula: "+salida.getBarco().getMatricula());
        }
        if (encontrado) {
            throw new DuplicateException("La salida del barco " + salida.getBarco().getMatricula() + " y fecha/hora " + salida.getFecha_hora() + " ya está registrada");
        }
            return salidaRepository.save(salida);
    }

    @Override
    public Salida updateSalida(Integer id, Salida salida) throws NotFoundException {
        if(!salidaRepository.existsById(id)){
            throw new NotFoundException("Salida con fecha y hora " + salida.getFecha_hora() + " e id "+id+" no encontrada");
        }else {
            Salida salida_db = salidaRepository.findById(id).get();

            if (Objects.nonNull(salida.getDestino()) && !"".equalsIgnoreCase(salida.getDestino())) {
                salida_db.setDestino(salida.getDestino());
            }

            if (Objects.nonNull(salida.getBarco()) && Objects.nonNull(salida.getBarco().getMatricula()) && !"".equalsIgnoreCase(salida.getBarco().getMatricula())) {
                salida_db.setBarco_matricula(salida.getBarco().getMatricula());
            }

            return salidaRepository.save(salida_db);
        }
    }

    @Override
    public Salida deleteSalida(Integer id) throws NotFoundException {
        Salida salida = salidaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Salida no encontrada con ID: " + id));
        salidaRepository.deleteById(id);
        return salida;
    }
}
