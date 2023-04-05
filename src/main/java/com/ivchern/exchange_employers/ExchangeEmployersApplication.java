package com.ivchern.exchange_employers;


import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TODO: add liquidbase
@SpringBootApplication
@SecurityScheme(
		name = "JWT",
		type = SecuritySchemeType.HTTP,
		bearerFormat = "JWT",
		scheme = "bearer"
)
public class ExchangeEmployersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeEmployersApplication.class, args);
	}

//	 @Bean
//	 public CommandLineRunner dataLoader(RoleRepository repo) {
//	 	return new CommandLineRunner() {
//	 		@Override
//	 		public void run(String... args) throws Exception {
//	 			repo.save(new ());
//	 		}
//	 	};
//	}
}
