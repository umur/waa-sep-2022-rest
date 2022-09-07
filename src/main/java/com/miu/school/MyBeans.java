package com.miu.school;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration

public class MyBeans {

    @Bean
    public ModelMapper modelMapper(){
        //ModelMapper modelMapper = new ModelMapper();
        return new ModelMapper();
    }



}
