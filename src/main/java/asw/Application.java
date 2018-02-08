package asw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import asw.dbManagement.model.Agent;
import asw.dbManagement.repository.AgentRepository;
import asw.participants.webService.htmlController.ReaderSingleton;

import java.text.ParseException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class Application {
	
	//public static ReaderSingleton instancia;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner initDB(AgentRepository repository) throws ParseException {
		
		//instancia=ReaderSingleton.getInstance("src/main/resources/maestro.csv");

		return (args) -> {
			// Inserción en la base de datos
			repository.save(new Agent("Paco Gómez", "-3.7339100,40.4416800","paco@hotmail.com", 1,
					"13864928P", "13864928P", "123456"));
			
			// Inserción en la base de datos
			repository.save(new Agent("Pepe Fernández", "1.7339100,26.4416800", "pepe@gmail.com", 1,
					"87654321B", "87654321B", "123456"));

			// Inserción en la base de datos
			repository.save(new Agent("Carmen López", "5.7339100,48.4416800", "carmen@yahoo.com", 1,
					"11223344C", "11223344C", "123456"));

		};
	}
}