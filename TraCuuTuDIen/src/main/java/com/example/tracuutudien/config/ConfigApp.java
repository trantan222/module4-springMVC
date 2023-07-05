package com.example.tracuutudien.config;

import com.example.tracuutudien.repository.TuDienMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigApp {
    @Bean
    public TuDienMap map(){
        return new TuDienMap();
    }

}
