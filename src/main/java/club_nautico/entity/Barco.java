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
    private String socio_dni;
}
