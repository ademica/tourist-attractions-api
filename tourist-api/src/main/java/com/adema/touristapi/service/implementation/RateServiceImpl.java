package com.adema.touristapi.service.implementation;

import com.adema.touristapi.model.Rate;
import com.adema.touristapi.repo.AttractionRepository;
import com.adema.touristapi.repo.RateRepository;
import com.adema.touristapi.service.RateService;
import org.springframework.stereotype.Service;

@Service
public class RateServiceImpl implements RateService {

    private final RateRepository rateRepository;
    private final AttractionRepository attractionRepository;

    public RateServiceImpl(RateRepository rateRepository, AttractionRepository attractionRepository) {
        this.rateRepository = rateRepository;
        this.attractionRepository = attractionRepository;
    }

    @Override
    public Rate createRate(Long attractionId, Rate rate) {
       return attractionRepository.findById(attractionId).map(attraction -> {
           rate.setAttraction(attraction);
           return rateRepository.save(rate);
        }).orElseThrow(() -> new IllegalStateException("Not found"));
    }
}
