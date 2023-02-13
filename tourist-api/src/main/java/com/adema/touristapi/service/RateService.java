package com.adema.touristapi.service;

import com.adema.touristapi.model.Rate;

public interface RateService {
    Rate createRate(Long attractionId, Rate rate);
}
