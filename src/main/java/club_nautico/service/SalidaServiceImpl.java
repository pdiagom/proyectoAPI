package club_nautico.service;

import club_nautico.entity.Salida;
import club_nautico.repository.SalidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class SalidaServiceImpl implements SalidaService{
    @Autowired
    SalidaRepository salidaRepository;

    @Override
    public List<Salida> findAllSalidas() {return salidaRepository.findAll();}

    @Override
    public Salida saveSalida(Salida salida) {
        return salidaRepository.save(salida);
    }

    @Override
    public Salida updateSalida(Integer id, Salida salida) {

        Salida salidaDatabase = salidaRepository.findById(id).get();

        if(Objects.nonNull(salida.getDestino()) && !"".equalsIgnoreCase(salida.getDestino())){
            salidaDatabase.setDestino(salida.getDestino());
        }
        if(Objects.nonNull(salida.getPatron_nombre()) && !"".equalsIgnoreCase(salida.getPatron_nombre())){
            salidaDatabase.setPatron_nombre(salida.getPatron_nombre());
        }
        if(Objects.nonNull(salida.getPatron_apellido()) && !"".equalsIgnoreCase(salida.getPatron_apellido())){
            salidaDatabase.setPatron_apellido(salida.getPatron_apellido());
        }
        if(Objects.nonNull(salida.getPatron_dni()) && !"".equalsIgnoreCase(salida.getPatron_dni())){
            salidaDatabase.setPatron_dni(salida.getPatron_dni());
        }
        if(Objects.nonNull(salida.getBarco_matricula()) && !"".equalsIgnoreCase(salida.getBarco_matricula())){
            salidaDatabase.setBarco_matricula(salida.getBarco_matricula());
        }

        return salidaRepository.save(salidaDatabase);
    }

    @Override
    public void deleteSalida(Integer id) {
        salidaRepository.deleteById(id);
    }
}
