package asw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import asw.dbManagement.model.Agent;
import asw.dbManagement.repository.ParticipantRepository;

import java.text.ParseException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner initDB(ParticipantRepository repository) throws ParseException {

		return (args) -> {
			// Inserción en la base de datos
			repository.save(new Agent("Paco Gómez", "-3.7339100,40.4416800","paco@hotmail.com", "13864928P",
					"Person", 1, "123456"));

		};
	}
}