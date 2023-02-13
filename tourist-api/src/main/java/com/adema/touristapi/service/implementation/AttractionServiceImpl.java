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
    public void addAttraction(Attraction attraction) {
        attractionRepository.save(attraction);
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
    public Attraction update(Attraction attraction) {
        return attractionRepository.save(attraction);
    }

    @Override
    public void delete(Long id) {
        attractionRepository.deleteById(id);
    }

    @Override
    public Attraction activate(Long id) {
        return null;
    }
}
