# weather-tracker
Weather-Tracker Microservice


## Overview
This repo contains a micro-service which interacts with Accuweather to get the current weather condition for a given city and a postcode. To get the data from Accuweather, I have used Accuweather APIs which are exposed by Accuweather.

## Technology Used
Java 8
Spring
SpringBoot

## Few Pointers
- API reference for Accuweather can be found in the URL https://developer.accuweather.com/apis
- One can understand the Accuweather API flow using the url https://developer.accuweather.com/api-flow-diagram
- I would advise you to go through the API documentation first, understand what Accuweather provides that suits your need.
- For my sample application, I wanted to understand on how can I get the current weather condition of a particular city or for a particular postcode. Hence, I have experimented CurrentConditionAPI.
- Likewise, you can experiment ForecastAPI, IndicesAPI, WeatherAlarms API.
- Accuweather has another API called LocationAPI. This API helps us to get a locationKey for a particular location. This locationKey has to be retrieved before invoking other APIs. LocationAPIKey has to be passed as a Pathvariable in most Accuweather API GET calls.


## Authorization 
- Whilst Accuweather provides number of APIs, it has Protected all its APIs. 
- Accuweather API has a fair ask of sending the APIKey in the request param to prove the authenticity of its consumers. 
- Hence, we will have to create a account with Accuweather followed by there is a need to create a APP. 
- By creating Accuweather APP, you will be assigned a API Key. This APIKey will have to be used in all the Accuweather API request as a queryParam.

## Accuweather Pricing
- Accuweather has got a pricing model as well to address the customer needs. Please refer to this page https://developer.accuweather.com/packages and chose the appropriate plan. As my project was for a POC and self-learning purpose, I have chosen standard free tariff which will enable free 50 API calls/day.