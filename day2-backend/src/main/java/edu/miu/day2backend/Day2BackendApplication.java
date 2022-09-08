package edu.miu.day2backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class Day2BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day2BackendApplication.class, args);
	}

}
