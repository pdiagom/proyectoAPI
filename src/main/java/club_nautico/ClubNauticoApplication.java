package club_nautico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackages = {"club_nautico.*"})
public class ClubNauticoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClubNauticoApplication.class, args);
	}

}
