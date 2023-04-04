package com.ivchern.exchange_employers;


import com.ivchern.exchange_employers.Model.Role;
import com.ivchern.exchange_employers.Repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//TODO: add liquidbase
@SpringBootApplication
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
