package tech.zyambo.srapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SrapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrapiApplication.class, args);
		System.out.println("srapi Server is running...");
	}
}
