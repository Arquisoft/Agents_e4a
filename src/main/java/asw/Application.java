package asw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import asw.dbManagement.model.Agent;
import asw.dbManagement.repository.AgentRepository;

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
	public CommandLineRunner initDB(AgentRepository repository) throws ParseException {

		return (args) -> {
			// Inserción en la base de datos
			repository.save(new Agent("Paco Gómez", "-3.7339100,40.4416800","paco@hotmail.com", "13864928P",
					"Person", 1, "123456"));
			
			// Inserción en la base de datos
			repository.save(new Agent("Pepe Fernández", "1.7339100,26.4416800", "pepe@gmail.com", "87654321B",
					"Person", 1, "123456"));

			// Inserción en la base de datos
			repository.save(new Agent("Carmen López", "5.7339100,48.4416800", "carmen@yahoo.com", "11223344C",
					"Person", 1, "123456"));

		};
	}
}