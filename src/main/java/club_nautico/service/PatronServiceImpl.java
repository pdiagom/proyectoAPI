package club_nautico.service;

import club_nautico.entity.Patron;
import club_nautico.entity.Socio;
import club_nautico.repository.PatronRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PatronServiceImpl implements PatronService{
    PatronRepository patronRepository;

    @Override
    public List<Patron> findAllPatrones() {
        return patronRepository.findAll();
    }

    @Override
    public Patron savePatron(Patron patron) {
        return patronRepository.save(patron);
    }

    @Override
    public Patron updatePatron(int id_patron, Patron patron) {

        Patron patron_db =patronRepository.findById(id_patron).get();

        if(Objects.nonNull(patron.getNombre()) && !" ".equalsIgnoreCase(patron.getNombre())){
            patron_db.setNombre(patron.getNombre());
        }

        if(Objects.nonNull(patron.getApellido()) && !" ".equalsIgnoreCase(patron.getApellido())){
            patron_db.setApellido(patron.getApellido());
        }
        return patronRepository.save(patron_db);
    }

    @Override
    public void deletePatron(int id) {
        patronRepository.deleteById(id);
    }
}
