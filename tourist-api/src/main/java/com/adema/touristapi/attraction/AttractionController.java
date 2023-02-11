package com.adema.touristapi.attraction;

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
    //pronadji po nazivu i vaznosti

    @PostMapping
    public void registerNewAttraction(@RequestBody Attraction attraction){
        attractionService.addNewAttraction(attraction);
    }

    @DeleteMapping(path = "{attractionId}")
    public void deleteAttraction(@PathVariable("attractionId") Long attractionId){
        attractionService.deleteStudent(attractionId);
    }

    //uraditi aktivaciju znamenitosti

    @PutMapping(path = "{attractionId}")
    public void updateAttraction(
            @PathVariable("attractionId") Long attractionId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String lat,
            @RequestParam(required = false) String lon,
            @RequestParam(required = false) Attraction.Significance significance) {
        attractionService.updateAttraction(attractionId,name, country, city, description, lat, lon, significance);
    }


}
