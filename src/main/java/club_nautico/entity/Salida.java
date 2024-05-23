package club_nautico.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

@Entity
@Table(name="salida")
@Data               //Todos los getters y setters
@AllArgsConstructor //Todos los constructores de salida
@NoArgsConstructor  //El constructor sin parametros
@Builder
public class Salida {

    @Id
    private int id;
    private Timestamp fecha_hora;
    private String destino;
    private String patron_nombre;
    private String patron_apellido;
    private String patron_dni;
    private String barco_matricula;
    private String socio_dni;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Timestamp fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getPatron_nombre() {
        return patron_nombre;
    }

    public void setPatron_nombre(String patron_nombre) {
        this.patron_nombre = patron_nombre;
    }

    public String getPatron_apellido() {
        return patron_apellido;
    }

    public void setPatron_apellido(String patron_apellido) {
        this.patron_apellido = patron_apellido;
    }

    public String getPatron_dni() {
        return patron_dni;
    }

    public void setPatron_dni(String patron_dni) {
        this.patron_dni = patron_dni;
    }

    public String getBarco_matricula() {
        return barco_matricula;
    }

    public void setBarco_matricula(String barco_matricula) {
        this.barco_matricula = barco_matricula;
    }

    public String getSocio_dni() {
        return socio_dni;
    }

    public void setSocio_dni(String socio_dni) {
        this.socio_dni = socio_dni;
    }
}
