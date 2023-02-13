package com.adema.touristapi.service;

import com.adema.touristapi.enumeration.Significance;
import com.adema.touristapi.model.Attraction;

import java.util.List;

public interface AttractionService {
    void addAttraction(Attraction attraction);
    List<Attraction> getAttractions();
    Attraction getAttractionByName(String name);
    List<Attraction> getAttractionsBySiginificance(Significance significance);
    Attraction update(Attraction attraction);
    void delete(Long id);
    Attraction activate(Long id);
}
