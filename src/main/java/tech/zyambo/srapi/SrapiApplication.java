package tech.zyambo.srapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"tech.zyambo.srapi.controllers"})
@EntityScan("tech.zyambo.srapi.model")
@EnableJpaRepositories("tech.zyambo.srapi.repository")
public class SrapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrapiApplication.class, args);
		System.out.println("srapi Server is running...");
	}

}
