package it.unisannio.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication(scanBasePackages = {
        "it.unisannio.presentation",
        "it.unisannio.domain",
        "it.unisannio.application",
        "it.unisannio.infrastructure"
})
@EntityScan("it.unisannio.infrastructure.*")
@EnableMongoRepositories(basePackages = "it.unisannio.infrastructure")
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

}
