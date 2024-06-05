package club_nautico.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.SocketImpl;


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
    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="socio_dni")
    private Socio socio;

    public int getId_patron() {
        return id_patron;
    }

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

    public String getSocio_dni() {
        return socio.getSocio_dni();
        }
}
