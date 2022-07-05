package it.unisannio.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {
        "it.unisannio.presentation",
        "it.unisannio.domain",
        "it.unisannio.application",
        "it.unisannio.infrastructure"
})
@EntityScan("it.unisannio.infrastructure*")
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

}
