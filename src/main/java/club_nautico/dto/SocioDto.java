package club_nautico.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocioDto {
    private String socio_dni;
    private String nombre;
    private String apellido;
}
