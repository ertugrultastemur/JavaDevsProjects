package kodlama.io.Devs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kodlama.io.Devs.dataAccess.concretes.InMemoryPLangRepository;

@SpringBootApplication
public class DevsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevsApplication.class, args);

	}

}
