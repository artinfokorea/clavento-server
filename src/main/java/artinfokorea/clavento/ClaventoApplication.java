package artinfokorea.clavento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ClaventoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClaventoApplication.class, args);
	}

}
