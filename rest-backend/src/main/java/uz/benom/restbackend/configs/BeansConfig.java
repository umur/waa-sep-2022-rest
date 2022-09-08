package uz.benom.restbackend.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean(name = "modelMapper")
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
