package club_nautico.service;

import club_nautico.entity.Patron;
import club_nautico.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PatronService {
    List<Patron> findAllPatrones();
    Patron findPatronById(int id_patron) throws NotFoundException;
    Patron savePatron(Patron patron);
    Patron updatePatron(int id, Patron patron);
    String deletePatron(int id);

}