package club_nautico.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name="socio")
@Data               //Todos los getters y setters
@AllArgsConstructor //Todos los constructores de salida
@NoArgsConstructor  //El constructor sin parametros
public class Socio {
    @Id
    private String socio_dni;
    private String nombre;
    private String apellido;
    @JsonIgnore
    @OneToMany(mappedBy="socio", cascade = CascadeType.ALL,orphanRemoval=true)
    private List<Barco> listaBarcos;
    @JsonIgnore
    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Patron> listaPatrones;

    public String getSocio_dni() {
        return socio_dni;
    }

    public void setSocio_dni(String socio_dni) {
        this.socio_dni = socio_dni;
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

    public List<Barco> getListaBarcos() {
        return listaBarcos;
    }
}
