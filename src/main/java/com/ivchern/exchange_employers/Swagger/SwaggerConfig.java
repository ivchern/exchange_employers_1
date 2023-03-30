package com.ivchern.exchange_employers.Swagger;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

import java.util.List;

//import static jdk.internal.org.jline.reader.impl.LineReaderImpl.CompletionType.List;

//@Configuration
public class SwaggerConfig {
//    @Bean
//    public OpenAPI myOpenAPI() {
//
//
//
//        Server devServer = new Server();
//        devServer.setUrl("1/swagger-ui/");
//        devServer.setDescription("Server URL in Development environment");
//
//        Contact contact = new Contact();
//        contact.setEmail("local");
//        contact.setName("local");
//        contact.setUrl("https://www.local.com");
//
//        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");
//
//        Info info = new Info()
//                .title("Tutorial Management API")
//                .version("1.0")
//                .contact(contact)
//                .description("This API exposes endpoints to manage tutorials.").termsOfService("https://www.local.com/terms")
//                .license(mitLicense);
//
//        return new OpenAPI().info(info).servers(List.of(devServer, devServer));
//    }

}