package club_nautico.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="socio")
@Data               //Todos los getters y setters
@AllArgsConstructor //Todos los constructores de salida
@NoArgsConstructor  //El constructor sin parametros
public class Socio {
    @Id
    private String dni;
    private String nombre;
    private String apellido;

}
