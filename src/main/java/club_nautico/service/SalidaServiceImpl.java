package club_nautico.service;


import club_nautico.entity.Salida;
import club_nautico.exception.DuplicateException;
import club_nautico.exception.NotFoundException;
import club_nautico.repository.SalidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;


@Service
public class SalidaServiceImpl implements SalidaService{
    @Autowired
    SalidaRepository salidaRepository;

    @Override
    public List<Salida> findAllSalidas() {return salidaRepository.findAll();}

    @Override
    public Salida findSalidaById(int id_salida) throws NotFoundException {
        return salidaRepository.findById(id_salida).orElseThrow(()-> new NotFoundException("Salida con id " + id_salida + " no encontrado"));
    }

    @Override
    public Salida saveSalida(Salida salida) throws DuplicateException {

        Iterator<Salida> iter = salidaRepository.findAll().iterator();
        boolean encontrado = false;

        while (iter.hasNext()) {
            Salida salidaAux = iter.next();
            if (salidaAux.getDestino().equals(salida.getDestino()) &&
                    salidaAux.getFecha_hora().equals(salida.getFecha_hora()) &&
                    salidaAux.getBarco_matricula().equals(salida.getBarco_matricula())) {
                encontrado = true;
                break;
            }
        }

        if (salidaRepository.existsById(salida.getId_salida())) {
            throw new DuplicateException("La salida con ID " + salida.getId_salida() + " ya está registrada");
        }

        if (encontrado) {
            throw new DuplicateException("La salida con destino " + salida.getDestino() + " y fecha/hora " + salida.getFecha_hora() + " ya está registrada");
        }else {
            return salidaRepository.save(salida);
        }



    }

    @Override
    public Salida updateSalida(Integer id, Salida salida) throws NotFoundException {
        if(!salidaRepository.findAll().contains(salida)){
            throw new NotFoundException("Salida con fecha y hora " + salida.getFecha_hora() + " no encontrada");
        }else {
            Salida salida_db = salidaRepository.findById(id).get();

            if (Objects.nonNull(salida.getDestino()) && !"".equalsIgnoreCase(salida.getDestino())) {
                salida_db.setDestino(salida.getDestino());
            }
            if (salida.getId_patron() > 0) {
                salida_db.setId_patron(salida.getId_patron());
            } else {
                salida_db.setId_patron(salida_db.getId_patron());
            }
            if (Objects.nonNull(salida.getBarco_matricula()) && !"".equalsIgnoreCase(salida.getBarco_matricula())) {
                salida_db.setBarco_matricula(salida.getBarco_matricula());
            }

            return salidaRepository.save(salida_db);
        }
    }

    @Override
    public String deleteSalida(Integer id) throws NotFoundException {
        Salida salida = salidaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Salida no encontrada con ID: " + id));
        salidaRepository.deleteById(id);
        return "Salida borrada correctamente";
    }
}
