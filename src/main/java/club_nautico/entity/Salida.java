package club_nautico.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;


@Entity
@Table(name="salida")
@Data               //Todos los getters y setters
@AllArgsConstructor //Todos los constructores de salida
@NoArgsConstructor  //El constructor sin parametros
public class Salida {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_salida;
    private OffsetDateTime fecha_hora = OffsetDateTime.now(ZoneOffset.UTC);
    private String destino;
    @OneToOne()
    @JoinColumn(name = "barco_matricula", referencedColumnName = "matricula")
    private Barco barco;
    @OneToOne()
    @JoinColumn(name = "id_patron")
    private Patron patron;


    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public OffsetDateTime getFecha_hora() {
        return fecha_hora;
    }

    public Patron getPatron() {
        return patron;
    }


    public Barco getBarco() {
        return barco;
    }
    public void setBarco_matricula(String matricula){
        barco.setMatricula(matricula);
    }

    public int getId_salida() {
        return id_salida;
    }
}
