package com.ivchern.exchange_employers;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TODO: add liquidbase
@SpringBootApplication
public class ExchangeEmployersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeEmployersApplication.class, args);
	}
//	@Bean
//	public GroupedOpenApi actuatorApi(OpenApiCustomiser actuatorOpenApiCustomiser,
//									  OperationCustomizer actuatorCustomizer,
//									  WebEndpointProperties endpointProperties,
//									  @Value("${springdoc.version}") String appVersion) {
//		return GroupedOpenApi.builder()
//				.group("Actuator")
//				.pathsToMatch(endpointProperties.getBasePath() + ALL_PATTERN)
//				.addOpenApiCustomiser(actuatorOpenApiCustomiser)
//				.addOpenApiCustomiser(openApi -> openApi.info(new Info().title("Actuator API").version(appVersion)))
//				.addOperationCustomizer(actuatorCustomizer)
//				.pathsToExclude("/rest/actuator/health/**")
//				.pathsToExclude("/rest/actuator/health/*")
//				.build();
//	}
//
//	@Bean
//	public GroupedOpenApi usersGroup(@Value("${springdoc.version}") String appVersion) {
//		return GroupedOpenApi.builder().group("users")
//				.addOperationCustomizer((operation, handlerMethod) -> {
//					operation.addSecurityItem(new SecurityRequirement().addList("basicScheme"));
//					return operation;
//				})
//				.addOpenApiCustomiser(openApi -> openApi.info(new Info().title("Users API").version(appVersion)))
//				.packagesToScan("org.springdoc.demo.app2")
//				.build();
//	}
//
//	@Bean
//	public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
//		return new OpenAPI()
//				.components(new Components())
//				.info(new Info().title("Customer accounts API").version(appVersion)
//						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
//	}

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
