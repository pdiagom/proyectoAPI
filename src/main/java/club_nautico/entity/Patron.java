package club_nautico.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="patron")
@Data               //Todos los getters y setters
@AllArgsConstructor
@NoArgsConstructor  //El constructor sin parametros
public class Patron {

    @Id
    private int id_patron;
    private String nombre;
    private String apellido;
    private String socio_dni;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
