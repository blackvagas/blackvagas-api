package br.com.blackvagas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BlackVagasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlackVagasApiApplication.class, args);
	}

}
