package it.unisannio.boot;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {
        "it.unisannio.presentation",
        "it.unisannio.domain",
        "it.unisannio.application",
        "it.unisannio.infrastructure"
})
@EntityScan("it.unisannio.infrastructure.*")
@EnableMongoRepositories(basePackages = "it.unisannio.infrastructure")
@OpenAPIDefinition(info = @Info(title = "Vehicles API",
        description = "API for CRUD operation on vehicles"),
        servers = {@Server(url = "/wcomp/api", description = "Default URL")})
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

}
