package club_nautico.service;

import club_nautico.entity.Socio;
import club_nautico.exception.DuplicateException;
import club_nautico.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SocioService {
    List<Socio> findAllSocios();
    Socio findSocioById(String socio_dni) throws NotFoundException;
    Socio saveSocio(Socio socio) throws DuplicateException;
    Socio updateSocio(String dni, Socio socio)throws NotFoundException;
    String deleteSocio(String id);

}
