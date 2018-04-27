package asw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import asw.agents.webService.CsvReader;

@SpringBootApplication
public class Application {
	
	public static CsvReader instancia;

	public static void main(String[] args) {
		instancia=CsvReader.getInstance("src/main/resources/maestro.csv");
		SpringApplication.run(Application.class, args);
	}	
}