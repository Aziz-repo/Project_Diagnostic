package com.example.demo.Client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class ClientConfig {
    @Bean
    CommandLineRunner commandLineRunner(ClientRepositrory repositrory){
        return args ->{
            Client client1 = new Client("Hassene", "Aziz", 7237768, "103","azizhassen69@gmail.com",54346342);
            Client client2 = new Client("Hassene", "Aicha", 7237769, "206","aichahassen@gmail.com",54346340);
            repositrory.saveAll(List.of(client1,client2));
        };
    
        
    }
     
}
