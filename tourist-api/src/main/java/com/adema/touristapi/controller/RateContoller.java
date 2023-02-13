package com.adema.touristapi.controller;

import com.adema.touristapi.model.Rate;
import com.adema.touristapi.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class RateContoller {

    private final RateService rateService;

    @Autowired
    public RateContoller(RateService rateService) {
        this.rateService = rateService;
    }

    @PostMapping("rate/{id}")
    public Rate rateAttraction (@PathVariable("id") Long id, @RequestBody Rate rate){
        return rateService.createRate(id, rate);
    }

}
