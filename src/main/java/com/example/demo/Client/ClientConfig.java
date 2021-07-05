package com.example.demo.Client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;
import com.example.demo.Rendez_vous.Rendez_vous;


@Configuration
public class ClientConfig {
    @Bean
    CommandLineRunner commandLineRunner(ClientRepositrory repositrory){
        Rendez_vous rendez_vous1 = new Rendez_vous();
        Rendez_vous rendez_vous2 = new Rendez_vous();
        return args ->{
            Client client1 = new Client("Hassene", "Aziz", 7237768,"azizhassen69@gmail.com",54346342,List.of(rendez_vous1));
            Client client2 = new Client("Hassene", "Aicha", 7237769,"aichahassen@gmail.com",54346340,List.of(rendez_vous2));
            repositrory.saveAll(List.of(client1,client2));
        };
    
        
    }
     
}
