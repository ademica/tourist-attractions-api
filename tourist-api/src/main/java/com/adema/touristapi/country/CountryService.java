package com.adema.touristapi.country;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CountryService {

    @GetMapping
    public List<Country> getCountries() {
        return List.of(
                new Country(
                        1L, "Bosnia and Herzegovina","BA"
                )
        );
    }

}
