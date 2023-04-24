package com.ivchern.exchange_employers;


import com.ivchern.exchange_employers.Controllers.AuthController;
import com.ivchern.exchange_employers.Model.User.User;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//TODO: add liquidbase
@SpringBootApplication
@Log4j
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
	@Bean
	public CommandLineRunner LoadData(AuthController authController) {
		return (args) -> {
			authController.registerUser(new User("test1", "test1@test.test", "123456"));
			authController.registerUser(new User("test2", "test2@test.test", "123456"));
			authController.registerUser(new User("test3", "test3@test.test", "123456"));
			System.out.println("create users");
		};
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
