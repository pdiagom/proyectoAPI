package club_nautico.service;

import club_nautico.entity.Socio;
import club_nautico.entity.Barco;
import club_nautico.exception.DuplicateException;
import club_nautico.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface SocioService {
    List<Socio> findAllSocios();
    List<Barco> findAllSocioBarcos(String socio_dni) throws NotFoundException;
    Socio findSocioById(String socio_dni) throws NotFoundException;
    Socio saveSocio(Socio socio) throws DuplicateException;
    Socio updateSocio(String dni, Socio socio)throws NotFoundException;
    String deleteSocio(String id)throws NotFoundException;

}
