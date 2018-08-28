package com.various.restservice.interactors;

import com.various.restservice.entity.FuelData;

import java.text.ParseException;

/**
 * Created by alex on 8/28/18.
 */
public interface FuelDataInteractor {
    public FuelData getFuelData(
            String fueltype,
            String price,
            String volume,
            String date,     //mm.dd.yyyy
            int driverid)
            throws ParseException;
}
