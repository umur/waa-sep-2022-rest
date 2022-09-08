package edu.miu.phase3;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBean {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
