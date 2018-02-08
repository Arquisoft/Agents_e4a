package asw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import asw.dbManagement.model.Agent;
import asw.dbManagement.repository.AgentRepository;
import asw.participants.webService.htmlController.ReaderSingleton;

import java.text.ParseException;
import java.util.Date;

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
		Date date = new Date(System.currentTimeMillis());
		//instancia=ReaderSingleton.getInstance("src/main/resources/maestro.csv");
		
		return (args) -> {
			// Inserción en la base de datos
			
			repository.save(new Agent("Paco Gómez", "Francisco", "paco@hotmail.com", date, "-3.7339100,40.4416800", "Español", "13864928P", 1, "123456","13864928P","13864928P"));
			
			
			// Inserción en la base de datos
			repository.save(new Agent("Pepe Fernández", "Francisco", "pepe@gmail.com", date, "1.7339100,26.4416800", "Español", "87654321B", 1, "123456","87654321B","87654321B"));
			
			

			// Inserción en la base de datos
			repository.save(new Agent("Carmen López", "Francisco", "carmen@yahoo.com", date, "5.7339100,48.4416800", "Español", "11223344C", 1, "123456","11223344C","11223344C"));
			
		};
	}
}