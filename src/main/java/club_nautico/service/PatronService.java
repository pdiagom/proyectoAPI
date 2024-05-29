package club_nautico.service;

import club_nautico.entity.Patron;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PatronService {
    List<Patron> findAllPatrones();
    Optional<Patron> findPatronById(int id_patron);
    Patron savePatron(Patron patron);
    Patron updatePatron(int id, Patron patron);
    String deletePatron(int id);

}