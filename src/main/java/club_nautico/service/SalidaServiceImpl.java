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
    public List<Salida> findAllSalidas() {
        return List.of();
    }

    @Override
    public Salida saveSalida(Salida salida) {
        return salidaRepository.save(salida);
    }

    @Override
    public Salida updateLocal(Integer id, Salida salida) {

        Salida salidaDb = salidaRepository.findById(id).get();

        if(Objects.nonNull(salida.getDestino()) && !"".equalsIgnoreCase(salida.getDestino())){
            salidaDb.setDestino(salida.getDestino());
        }
        if(Objects.nonNull(salida.getPatron_nombre()) && !"".equalsIgnoreCase(salida.getPatron_nombre())){
            salidaDb.setPatron_nombre(salida.getPatron_nombre());
        }
        return null;
    }

    @Override
    public void deleteSalida(Integer id) {

    }
}
