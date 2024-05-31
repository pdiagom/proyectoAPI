package club_nautico.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @OneToMany
    private String socio_dni;

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

    public String getSocio_dni() {
        return socio_dni;
    }

    public void setSocio_dni(String socio_dni) {
        this.socio_dni = socio_dni;
    }
}

