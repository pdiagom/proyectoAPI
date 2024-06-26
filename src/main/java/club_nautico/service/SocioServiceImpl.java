package club_nautico.service;


import club_nautico.entity.Barco;
import club_nautico.entity.Socio;
import club_nautico.exception.DuplicateException;
import club_nautico.exception.NotFoundException;

import club_nautico.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class SocioServiceImpl implements SocioService{
    @Autowired
    SocioRepository socioRepository;

    @Override
    public List<Socio> findAllSocios(){

        return socioRepository.findAll();
    }

    @Override
    public List<Barco> findAllSocioBarcos(String socio_dni) throws NotFoundException {
       Socio socio= socioRepository.findById(socio_dni).orElseThrow(()-> new NotFoundException("Socio no encontrado con DNI: " + socio_dni));
        return socio.getListaBarcos();
    }

    @Override
    public Socio findSocioById(String socio_dni) throws NotFoundException {

        return socioRepository.findById(socio_dni).orElseThrow(()-> new NotFoundException("Socio no encontrado con DNI: " + socio_dni));
    }

    @Override
    public Socio saveSocio(Socio socio) throws DuplicateException {
        if (socioRepository.existsById(socio.getSocio_dni())) {
            throw new DuplicateException("El socio con dni " + socio.getSocio_dni() + " ya esta registrado");
        } else {
            return socioRepository.save(socio);
        }
    }

    @Override
    public Socio updateSocio(String dni, Socio socio) throws NotFoundException {
        if(!socioRepository.existsById(dni)){
            throw new NotFoundException("Socio con dni " + dni + " no encontrado");
        }else {
            Socio socio_db = socioRepository.findById(dni).get();

            if (Objects.nonNull(socio.getSocio_dni()) && !" ".equalsIgnoreCase(socio.getSocio_dni())) {
                socio_db.setSocio_dni(socio.getSocio_dni());
            }

            if (Objects.nonNull(socio.getNombre()) && !" ".equalsIgnoreCase(socio.getNombre())) {
                socio_db.setNombre(socio.getNombre());
            }

            if (Objects.nonNull(socio.getApellido()) && !" ".equalsIgnoreCase(socio.getApellido())) {
                socio_db.setApellido(socio.getApellido());
            }
            return socioRepository.save(socio_db);
        }
    }

    @Override
    public Socio deleteSocio(String socio_dni) throws NotFoundException {
        Socio socio = socioRepository.findById(socio_dni)
                .orElseThrow(() -> new NotFoundException("Socio no encontrado con DNI: " + socio_dni));

        socioRepository.deleteById(socio_dni);
        return socio;
    }
}
