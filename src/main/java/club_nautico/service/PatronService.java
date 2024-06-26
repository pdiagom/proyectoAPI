package club_nautico.service;

import club_nautico.entity.Patron;
import club_nautico.exception.DuplicateException;
import club_nautico.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatronService {
    List<Patron> findAllPatrones();
    Patron findPatronById(int id_patron) throws NotFoundException;
    Patron savePatron(Patron patron) throws DuplicateException, NotFoundException;
    Patron updatePatron(int id, Patron patron)throws NotFoundException;
    Patron deletePatron(int id)throws NotFoundException;

}