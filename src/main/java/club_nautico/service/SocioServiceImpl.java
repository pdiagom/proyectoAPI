package club_nautico.service;

import club_nautico.entity.Barco;
import club_nautico.entity.Socio;
import club_nautico.exception.NotFoundException;
import club_nautico.repository.BarcoRepository;
import club_nautico.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SocioServiceImpl implements SocioService{
    @Autowired
    SocioRepository socioRepository;

    @Override
    public List<Socio> findAllSocios(){

        return socioRepository.findAll();
    }

    @Override
    public Socio findSocioById(String socio_dni) throws NotFoundException {
        return socioRepository.findById(socio_dni).orElseThrow(()-> new NotFoundException("Socio con dni " + socio_dni + " no encontrado"));
    }

    @Override
    public Socio saveSocio(Socio socio) {

        return socioRepository.save(socio);
    }

    @Override
    public Socio updateSocio(String dni, Socio socio) {

        Socio socio_db =socioRepository.findById(dni).get();

        if(Objects.nonNull(socio.getSocio_dni()) && !" ".equalsIgnoreCase(socio.getSocio_dni())){
            socio_db.setSocio_dni(socio.getSocio_dni());
        }

        if(Objects.nonNull(socio.getNombre()) && !" ".equalsIgnoreCase(socio.getNombre())){
            socio_db.setNombre(socio.getNombre());
        }

        if(Objects.nonNull(socio.getApellido()) && !" ".equalsIgnoreCase(socio.getApellido())){
            socio_db.setApellido(socio.getApellido());
        }
        return socioRepository.save(socio_db);
    }

    @Override
    public String deleteSocio(String dni) {
    socioRepository.deleteById(dni);
    return "Socio borrado correctamente";
    }
}
