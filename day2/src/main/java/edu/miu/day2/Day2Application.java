package edu.miu.day2;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;

@SpringBootApplication
public class Day2Application {

	public static void main(String[] args) {
		SpringApplication.run(Day2Application.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
}
}
