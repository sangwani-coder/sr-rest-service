package tech.zyambo.srapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"tech.zyambo.srapi.model.service"})
public class SrapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrapiApplication.class, args);
		System.out.println("srapi Server is running...");
	}
}
