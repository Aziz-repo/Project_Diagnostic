package com.example.demo.Rendez_vous;


import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

import com.example.demo.Voiture.Voiture;

import org.springframework.context.annotation.Bean;



@Configuration
public class Rendez_vousConfig {
    
    @Bean
    public Rendez_vousService rendez_vousService(Rendez_vousRepository rendez_vousRepository){
        Voiture voiture = new Voiture("Peugeot","206",070);
        Rendez_vous rendez_vous = new Rendez_vous(voiture,LocalDate.of(2021, 8, 4));
        rendez_vousRepository.save(rendez_vous);
        return new Rendez_vousService(rendez_vousRepository);
    }
}
