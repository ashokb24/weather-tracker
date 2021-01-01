package com.ashok.weathertracker.services;

import com.ashok.weathertracker.model.CurrentConditionDTO;
import com.ashok.weathertracker.model.CurrentConditionMapBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CurrentConditionService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${accuweather.api.key}")
    private String accuweatherApiKey;

    @Value("${current.condition.endpoint.url}")
    private String currentConditionApiEndPointUrl;

    /**
     * Method to get the currentcondition detail for a given locationKey
     * 
     * @param locationKey
     * @return
     */
    public CurrentConditionDTO getCurrentCondition(String locationKey) {
        currentConditionApiEndPointUrl = currentConditionApiEndPointUrl.replace("LOCATION_KEY", locationKey);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(currentConditionApiEndPointUrl)
                .queryParam("apikey", accuweatherApiKey);
        String response = restTemplate.getForObject(builder.toUriString(), String.class);
        System.out.println("CurrentConditionAPI Response "+response);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            CurrentConditionMapBean[] currentConditionMapBeans = objectMapper.readValue(response, CurrentConditionMapBean[].class);
            CurrentConditionDTO currentConditionDTO = new CurrentConditionDTO(currentConditionMapBeans[0]);
            return currentConditionDTO;
        } catch (JsonMappingException e) {
            throw new RuntimeException("JsonMapping Exception");
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JsonProcessing Exception");
        }
    }
}
