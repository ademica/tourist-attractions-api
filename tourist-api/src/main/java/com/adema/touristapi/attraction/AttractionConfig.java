package com.adema.touristapi.attraction;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AttractionConfig {

    @Bean
    CommandLineRunner commandLineRunner (AttractionRepository repository){
        return args -> {
            Attraction att1 = new Attraction(
                    "Gazi Husrev-Begova Biblioteka",
                    "Bosna i Hercegovina",
                    "Sarajevo",
                    "Opis atrakcije",
                    "53.2734",
                    "-7.77832031",
                    Attraction.Significance.INEVITABLE
            );

            Attraction att2 = new Attraction(
                    "Stari Grad",
                    "Bosna i Hercegovina",
                    "Velika Kladuša",
                    "Opis neki",
                    "12.12345",
                    "18.765",
                    Attraction.Significance.SIGNIFICANT
            );

            repository.saveAll(
                    List.of(att1, att2)
            );

        };
    }
}
