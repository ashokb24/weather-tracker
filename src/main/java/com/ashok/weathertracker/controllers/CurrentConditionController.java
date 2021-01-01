package com.ashok.weathertracker.controllers;

import com.ashok.weathertracker.model.CurrentConditionDTO;
import com.ashok.weathertracker.services.CurrentConditionService;
import com.ashok.weathertracker.services.LocationKeyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrentConditionController {

    @Autowired
    private CurrentConditionService currentConditionService;

    @Autowired
    private LocationKeyService locationKeyService;

    /**
     * Rest Endpoint to get the current condition for a given cityname
     * 
     * @param cityName
     * @return
     */
    @GetMapping("/currentCondition/{city}/city")
    public CurrentConditionDTO getCurrentCondition(@PathVariable("city") String cityName) {
        String locationKeyName = locationKeyService.getLocationKeybyCityName(cityName);
        CurrentConditionDTO currentConditionDTO = currentConditionService.getCurrentCondition(locationKeyName);
        return currentConditionDTO;
    }

    /**
     * Rest Endpoint to get the current condition for a given postcode
     * @param postCode
     * @return
     */
    @GetMapping("/currentCondition/{postcode}/postcode")
    public CurrentConditionDTO getCurrentConditionByPostCode(@PathVariable("postcode") String postCode) {
        String locationKeyName = locationKeyService.getLocationKeybyPostCode(postCode);
        CurrentConditionDTO currentConditionDTO = currentConditionService.getCurrentCondition(locationKeyName);
        return currentConditionDTO;
    }
}
