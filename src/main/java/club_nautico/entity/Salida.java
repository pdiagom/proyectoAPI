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
    private int id_patron;
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

    public int getId_patron() {
        return id_patron;
    }

    public void setId_patron(int id_patron) {
        this.id_patron = id_patron;
    }

    public String getBarco_matricula() {
        return barco_matricula;
    }

    public void setBarco_matricula(String barco_matricula) {
        this.barco_matricula = barco_matricula;
    }

}
