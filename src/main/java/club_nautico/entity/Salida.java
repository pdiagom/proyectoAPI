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
}
