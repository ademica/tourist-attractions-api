package com.adema.touristapi.attraction;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttractionService {

    public List<Attraction> getAttractions(){
        return List.of(
                new Attraction(
                        1L,
                        "Gazi Husrev-Begova Biblioteka",
                        "Opis atrakcije",
                        "53.2734",
                        "-7.77832031")
        );
    }
}
