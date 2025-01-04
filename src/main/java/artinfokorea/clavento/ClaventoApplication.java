package artinfokorea.clavento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(servers = {
	@Server(url = "/", description = "Default Server URL")
})
@EnableJpaAuditing
@SpringBootApplication
public class ClaventoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClaventoApplication.class, args);
	}

}
