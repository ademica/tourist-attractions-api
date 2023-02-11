package com.adema.touristapi.attraction;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AttractionService {

    private final AttractionRepository attractionRepository;

    @Autowired
    public AttractionService(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    public List<Attraction> getAttractions(){
        return attractionRepository.findAll();
    }

    public void addNewAttraction(Attraction attraction) {
        Optional<Attraction> attractionByName = attractionRepository.findAttractionByName(attraction.getName());
        if(attractionByName.isPresent()) {
            throw new IllegalStateException("Attraction already exists.");
        }
        attractionRepository.save(attraction);
    }

    public void deleteStudent(Long attractionId) {
        boolean exists = attractionRepository.existsById(attractionId);
        if(!exists) {
            throw new IllegalStateException("Attraction does not exist");
        }
        attractionRepository.deleteById(attractionId);
    }

    @Transactional
    public void updateAttraction(
            Long attractionId,
            String name,
            String country,
            String city,
            String description,
            String lat,
            String lon,
            Attraction.Significance significance) {

        Attraction attraction = attractionRepository.findById(attractionId)
                .orElseThrow(() -> new IllegalStateException("Attraction does not exist"));

        if(name != null &&
                name.length() > 0 &&
                !Objects.equals(attraction.getName(), name)){
            Optional<Attraction> attractionOptional = attractionRepository
                    .findAttractionByName(name);
            if(attractionOptional.isPresent()) {
                throw new IllegalStateException("Name already taken.");
            }
            attraction.setName(name);
        }

        if(country != null &&
                country.length() > 0 &&
                !Objects.equals(attraction.getCountry(), country)){
            attraction.setCountry(country);
        }

        if(city != null &&
                city.length() > 0 &&
                !Objects.equals(attraction.getCity(), city)){
            attraction.setCity(city);
        }

        if(description != null &&
                description.length() > 0 &&
                !Objects.equals(attraction.getDescription(), description)){
            attraction.setDescription(description);
        }

        if(lat != null &&
                lat.length() > 0 &&
                !Objects.equals(attraction.getLat(), lat)){
            attraction.setLat(lat);
        }

        if(lon != null &&
                lon.length() > 0 &&
                !Objects.equals(attraction.getLon(), lon)){
            attraction.setLon(lon);
        }
    }
}
