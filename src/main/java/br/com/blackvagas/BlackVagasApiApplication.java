package br.com.blackvagas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BlackVagasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlackVagasApiApplication.class, args);
	}

}
