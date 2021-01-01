package com.ashok.weathertracker.services;

import com.ashok.weathertracker.model.LocationKeyMapBean;
import com.ashok.weathertracker.model.LocationKeyDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class LocationKeyService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${accuweather.api.key}")
    private String accuweatherApiKey;

    @Value("${locationapi.city.endpoint.url}")
    private String locationApiEndPointUrl;

    /**
     * Method to get the locationKey for a given cityName
     * 
     * @param cityName
     * @return
     */
    public String getLocationKeybyCityName(String cityName) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(locationApiEndPointUrl)
                .queryParam("q", cityName).queryParam("apikey", accuweatherApiKey);
        String response = restTemplate.getForObject(builder.toUriString(), String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            LocationKeyMapBean[] locationKeyMapBeanrray = objectMapper.readValue(response, LocationKeyMapBean[].class);
            LocationKeyDTO locationKeyDTO = new LocationKeyDTO(locationKeyMapBeanrray[0]);
            return locationKeyDTO.getLocationKey();
        } catch (JsonMappingException e) {
            throw new RuntimeException("JsonMapping Exception");
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JsonProcessing Exception");
        }
    }

    /**
     * Method to get the locationKey for a given PostCode
     * 
     * @param postCode
     * @return
     */
    public String getLocationKeybyPostCode(String postCode) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(locationApiEndPointUrl)
                .queryParam("q", postCode).queryParam("apikey", accuweatherApiKey);
        String response = restTemplate.getForObject(builder.toUriString(), String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            LocationKeyMapBean[] locationKeyMapBeanrray = objectMapper.readValue(response, LocationKeyMapBean[].class);
            LocationKeyDTO locationKeyDTO = new LocationKeyDTO(locationKeyMapBeanrray[0]);
            return locationKeyDTO.getLocationKey();
        } catch (JsonMappingException e) {
            throw new RuntimeException("JsonMapping Exception");
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JsonProcessing Exception");
        }
    }
}
