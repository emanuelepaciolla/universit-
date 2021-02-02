package com.web.university.guide.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GuideHelper {

    @Value("${city.by.name}")
    private String cityByName;

    public String getCityByName() {
        return cityByName;
    }
}
