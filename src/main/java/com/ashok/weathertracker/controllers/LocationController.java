package com.ashok.weathertracker.controllers;

import com.ashok.weathertracker.services.LocationKeyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

    @Autowired
    private LocationKeyService locationKeyService;

    /**
     * Method to get the LocationKey for a given City
     * 
     * @param cityName
     * @return
     */
    @GetMapping("/cityLocationKey/{city}")
    public String getLocationKeyByCityName(@PathVariable("city") String cityName) {
        String cityLocationKey = locationKeyService.getLocationKeybyCityName(cityName);
        return "cityLocationKey " + cityLocationKey;
    }

    /**
     * Method to get the LocationKey for a given Postcode
     * 
     * @param postCode
     * @return
     */
    @GetMapping("/postCodeLocationKey/{postcode}")
    public String getLocationKeyByPostCode(@PathVariable("postcode") String postCode) {
        String postCodeLocationKey = locationKeyService.getLocationKeybyPostCode(postCode);
        return "Postcode passed " + postCodeLocationKey;
    }
}
