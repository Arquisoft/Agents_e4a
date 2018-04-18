package asw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.expression.ParseException;

import asw.agents.webService.CsvReader;
import asw.dbManagement.model.Agent;
import asw.dbManagement.repository.AgentRepository;

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class Application {
	
	public static CsvReader instancia;

	public static void main(String[] args) {
		instancia=CsvReader.getInstance("src/main/resources/maestro.csv");
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner initDB(AgentRepository repository) throws ParseException {
		
		
		return (args) -> {
			
			
			// Inserción en la base de datos
			repository.save(new Agent("Paco Gómez", "paco@hotmail.com", "-3.7339100,40.4416800", 1, "13864928P", "123456"));
			
			
			// Inserción en la base de datos
			repository.save(new Agent("Pepe Fernández", "pepe@gmail.com", "1.7339100,26.4416800", 1, "87654321B", "123456"));
			
			

			// Inserción en la base de datos
			repository.save(new Agent("Carmen López", "carmen@yahoo.com", "5.7339100,48.4416800", 1, "11223344C", "123456"));
			
		};
	}
}