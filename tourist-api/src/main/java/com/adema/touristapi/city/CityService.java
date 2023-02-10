package com.adema.touristapi.city;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    public List<City> getCities() {
        return List.of(
                new City(
                        1L, "Sarajevo", "77230"
                )
        );
    }
}
