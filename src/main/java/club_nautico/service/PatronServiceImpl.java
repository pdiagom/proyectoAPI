package club_nautico.service;

import club_nautico.entity.Patron;
import club_nautico.exception.DuplicateException;
import club_nautico.exception.NotFoundException;
import club_nautico.repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

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
        Iterator<Patron> iter= patronRepository.findAll().iterator();
        boolean encontrado=false;
        while(iter.hasNext()){
            Patron patron_aux= iter.next();
            if(patron_aux.getNombre().equals(patron.getNombre())){
                if(patron_aux.getApellido().equals(patron.getApellido())) {
                    encontrado = true;
                }
            }
        }
        if(!patronRepository.findById(patron.getId_patron()).isEmpty()){
            throw new DuplicateException("El patron con id "+patron.getId_patron()+" ya esta registrado");
        }
        if(encontrado){
            throw new DuplicateException("El patron con nombre "+patron.getNombre()+" "+patron.getApellido()+" ya esta registrado");
        }else {
            return patronRepository.save(patron);
        }
    }

    @Override
    public Patron updatePatron(int id_patron, Patron patron) throws NotFoundException {
        if(!patronRepository.findAll().contains(patron)){
            throw new NotFoundException("Patron con id " + patron.getId_patron() + " no encontrado");
        }else {
            Patron patron_db = patronRepository.findById(id_patron).get();

            if (Objects.nonNull(patron.getNombre()) && !" ".equalsIgnoreCase(patron.getNombre())) {
                patron_db.setNombre(patron.getNombre());
            }

            if (Objects.nonNull(patron.getApellido()) && !" ".equalsIgnoreCase(patron.getApellido())) {
                patron_db.setApellido(patron.getApellido());
            }
            return patronRepository.save(patron_db);
        }
    }

    @Override
    public String deletePatron(int id) throws NotFoundException {
        Patron patron = patronRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Patron no encontrado con ID: " + id));
        patronRepository.deleteById(id);
        return "Patron borrado correctamente";
    }
}
