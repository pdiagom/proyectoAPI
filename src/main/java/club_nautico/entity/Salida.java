package club_nautico.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;


@Entity
@Table(name="salida")
@Data               //Todos los getters y setters
@AllArgsConstructor //Todos los constructores de salida
@NoArgsConstructor  //El constructor sin parametros
@Builder
public class Salida {

    @Id
    private int id;
    private OffsetDateTime fecha_hora = OffsetDateTime.now(ZoneOffset.UTC);
    private String destino;
    private String patron_nombre;
    private String patron_apellido;
    private String patron_dni;
    private String barco_matricula;


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

}
