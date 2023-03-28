package com.ivchern.exchange_employers;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExchangeEmployersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeEmployersApplication.class, args);
	}

//	 @Bean
//	 public CommandLineRunner dataLoader(ResourceExchangeRepository repo) {
//	 	return new CommandLineRunner() {
//	 		@Override
//	 		public void run(String... args) throws Exception {
//	 			repo.save(new ResourceExchange(1L, "HUI"));
//	 		}
//	 	};
//	}
}
