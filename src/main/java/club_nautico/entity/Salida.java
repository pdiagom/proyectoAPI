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
public class Salida {

    @Id
    private int id_salida;
    private OffsetDateTime fecha_hora = OffsetDateTime.now(ZoneOffset.UTC);
    private String destino;
    private int id_patron;
    private String barco_matricula;


    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public OffsetDateTime getFecha_hora() {
        return fecha_hora;
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

    public int getId_salida() {
        return id_salida;
    }
}
