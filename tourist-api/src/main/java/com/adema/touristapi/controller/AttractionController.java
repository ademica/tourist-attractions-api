package com.adema.touristapi.controller;

import com.adema.touristapi.enumeration.Significance;
import com.adema.touristapi.model.Attraction;
import com.adema.touristapi.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/attractions")
public class AttractionController {
    private final AttractionService attractionService;

    @Autowired
    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    @GetMapping
    public List<Attraction> getAttractions(){
        return attractionService.getAttractions();
    }

    @GetMapping(path = "/name")
    public Attraction getAttractionByName(String name) {return  attractionService.getAttractionByName(name);}

    @GetMapping("significance")
    public List<Attraction> getAttractionsBySignificance(Significance significance){
        return  attractionService.getAttractionsBySiginificance(significance);
    }

    @PostMapping
    public void registerNewAttraction(@RequestBody Attraction attraction){
        attractionService.addAttraction(attraction);
    }

    @DeleteMapping(path = "{attractionId}")
    public void deleteAttraction(@PathVariable("attractionId") Long attractionId){
        attractionService.delete(attractionId);
    }

    //uraditi aktivaciju znamenitosti




}
