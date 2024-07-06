package com.luv2code.springcoredemo.config;

import com.luv2code.springcoredemo.common.Coach;
import com.luv2code.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")  // Bean Id is changed to "aquatic" from "swimCoach" due to passing the argument inside @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
