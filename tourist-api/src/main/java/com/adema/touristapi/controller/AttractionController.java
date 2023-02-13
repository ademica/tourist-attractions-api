package com.adema.touristapi.controller;

import com.adema.touristapi.enumeration.Significance;
import com.adema.touristapi.model.Attraction;
import com.adema.touristapi.model.Response;
import com.adema.touristapi.service.AttractionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/attractions")
public class AttractionController {
    private final AttractionService attractionService;

    @Autowired
    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    @GetMapping
    public ResponseEntity<Response> getAllAttractions(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("attractions", attractionService.getAttractions()))
                        .message("List of attractions")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping(path = "/name")
    public Attraction getAttractionByName(String name) {return  attractionService.getAttractionByName(name);}

    @GetMapping("/significance")
    public List<Attraction> getAttractionsBySignificance(Significance significance){
        return  attractionService.getAttractionsBySiginificance(significance);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getAttraction(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("attraction", attractionService.getById(id)))
                        .message("Attraction")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<Response> saveAttraction(@RequestBody @Valid Attraction attraction) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("attraction", attractionService.addAttraction(attraction)))
                        .message("Attraction created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Response> deleteAttraction(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted", attractionService.delete(id)))
                        .message("Attraction succesfully deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    //uraditi aktivaciju znamenitosti
    //update znamenitosti

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateAttraction(@PathVariable("id") Long id, @RequestBody Attraction attraction) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("updated", attractionService.update(id,attraction)))
                        .message("Attraction updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }




}
