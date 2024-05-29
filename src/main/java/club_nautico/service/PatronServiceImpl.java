package club_nautico.service;

import club_nautico.entity.Patron;
import club_nautico.exception.DuplicateException;
import club_nautico.exception.NotFoundException;
import club_nautico.repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PatronServiceImpl implements PatronService{
    @Autowired
    PatronRepository patronRepository;

    @Override
    public List<Patron> findAllPatrones() {
        return patronRepository.findAll();
    }

    @Override
    public Patron findPatronById(int id_patron) throws NotFoundException {
        return patronRepository.findById(id_patron).orElseThrow(()-> new NotFoundException("Patron con id " + id_patron + " no encontrado"));
    }

    @Override
    public Patron savePatron(Patron patron) throws DuplicateException {
        if(patronRepository.findAll().contains(patron)){
            throw new DuplicateException("El patron con nombre "+patron.getNombre()+" ya esta registrado");
        }else {
            return patronRepository.save(patron);
        }
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
    public String deletePatron(int id) {
        patronRepository.deleteById(id);
        return "Patron borrado correctamente";
    }
}
