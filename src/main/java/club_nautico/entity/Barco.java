package club_nautico.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="barco")
@Data               //Todos los getters y setters
@AllArgsConstructor //Todos los constructores de salida
@NoArgsConstructor  //El constructor sin parametros
@Builder
public class Barco {

    @Id
    private String matricula;
    private String nombre;
    private String amarre;
    private double cuota;
    @JsonIgnore
    @JoinColumn(name="socio_dni")
    @ManyToOne()
    private Socio socio;
    @JsonIgnore
    @OneToMany(mappedBy = "barco", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Salida> listaSalida;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAmarre() {
        return amarre;
    }

    public void setAmarre(String amarre) {
        this.amarre = amarre;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public String getSocio() {
        return socio.getSocio_dni();
    }

   public void setSocio(String socio) {
       // this.so
    }
}

