package asw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import asw.agents.webService.CsvReader;

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class Application {
	
	public static CsvReader instancia;

	public static void main(String[] args) {
		instancia=CsvReader.getInstance("src/main/resources/maestro.csv");
		SpringApplication.run(Application.class, args);
	}

	
}