package com.adema.touristapi.controller;

import com.adema.touristapi.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RateContoller {

    private final RateService rateService;

    @Autowired
    public RateContoller(RateService rateService) {
        this.rateService = rateService;
    }
}
