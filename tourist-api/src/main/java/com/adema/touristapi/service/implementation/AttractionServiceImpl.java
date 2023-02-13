package com.adema.touristapi.service.implementation;

import com.adema.touristapi.enumeration.Significance;
import com.adema.touristapi.model.Attraction;
import com.adema.touristapi.repo.AttractionRepository;
import com.adema.touristapi.service.AttractionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AttractionServiceImpl implements AttractionService {

    private final AttractionRepository attractionRepository;

    public AttractionServiceImpl(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    @Override
    public Attraction addAttraction(Attraction attraction) {
        return attractionRepository.save(attraction);
    }

    @Override
    public List<Attraction> getAttractions() {
        return attractionRepository.findAll();
    }

    @Override
    public Attraction getAttractionByName(String name) {
        return attractionRepository.findAttractionByName(name).get();
    }

    @Override
    public List<Attraction> getAttractionsBySiginificance(Significance significance) {
        return attractionRepository.findAttractionsBySignificance(significance);
    }

    @Override
    public Attraction update(Long id, Attraction attraction) {
        Attraction _attraction = attractionRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("No attraction with id " + id));

        _attraction.setCity(attraction.getCity());
        _attraction.setCountry(attraction.getCountry());
        _attraction.setDescription(attraction.getDescription());
        _attraction.setLat(attraction.getLat());
        _attraction.setLon(attraction.getLon());
        _attraction.setSignificance(attraction.getSignificance());
        _attraction.setName(attraction.getName());

        return attractionRepository.save(_attraction);
    }

    @Override
    public Boolean delete(Long id) {
        attractionRepository.deleteById(id);
        return true;
    }

    @Override
    public Attraction activate(Long id) {
        return null;
    }

    @Override
    public Attraction getById(Long id) {
        return attractionRepository.findAttractionById(id);
    }
}
