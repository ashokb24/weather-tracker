package com.ashok.weathertracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CurrentConditionDTO {
    private String weatherCondition;
    private int temperatureInCelsius;
    private int temperatureInFarhenHeit;

    public CurrentConditionDTO(CurrentConditionMapBean currentConditionMapBean) {
        this.setWeatherCondition(currentConditionMapBean.getWeatherCondition());
        this.setTemperatureInCelsius(currentConditionMapBean.getTemperature().getMetric().getTemperatureValue());
        this.setTemperatureInFarhenHeit(currentConditionMapBean.getTemperature().getImperial().getTemperatureValue());

    }
}
