package club_nautico.exception.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@NoArgsConstructor
public class ErrorMessage {
    private HttpStatus status;
    private String message;


    public ErrorMessage(HttpStatus httpStatus, String message) {
        this.status=httpStatus;
        this.message=message;
    }
    public ErrorMessage(String message) {
    }
}
