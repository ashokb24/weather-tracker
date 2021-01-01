package com.ashok.weathertracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class LocationKeyDTO {
    
    private String locationKey;

    public LocationKeyDTO(LocationKeyMapBean locationKeyMapBean) {
        this.setLocationKey(locationKeyMapBean.getLocationKey());
    }
}
