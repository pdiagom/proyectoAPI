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

        Salida salida_db = salidaRepository.findById(id).get();

        if(Objects.nonNull(salida.getDestino()) && !"".equalsIgnoreCase(salida.getDestino())){
            salida_db.setDestino(salida.getDestino());
        }
        if(Objects.nonNull(salida.getPatron_nombre()) && !"".equalsIgnoreCase(salida.getPatron_nombre())){
            salida_db.setPatron_nombre(salida.getPatron_nombre());
        }
        if(Objects.nonNull(salida.getPatron_apellido()) && !"".equalsIgnoreCase(salida.getPatron_apellido())){
            salida_db.setPatron_apellido(salida.getPatron_apellido());
        }
        if(salida.getId_patron()>0){
            salida_db.setId_patron(salida.getId_patron());
        }else{
            salida_db.setId_patron(salida_db.getId_patron());
        }
        if(Objects.nonNull(salida.getBarco_matricula()) && !"".equalsIgnoreCase(salida.getBarco_matricula())){
            salida_db.setBarco_matricula(salida.getBarco_matricula());
        }

        return salidaRepository.save(salida_db);
    }

    @Override
    public void deleteSalida(Integer id) {
        salidaRepository.deleteById(id);
    }
}
