package com.various.restservice.interactors;

import com.various.restservice.entity.FuelData;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Acer on 28.08.2018.
 */
public class FuelDataInteractorImpl implements FuelDataInteractor {

    @Override
    public FuelData getFuelData(
            String fueltype,
            String price,
            String volume,
            String date,     //mm.dd.yyyy
            int driverid)
            throws ParseException
    {
    //    try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
            java.sql.Date dateSQL=new java.sql.Date(sdf.parse(date).getTime());
            FuelData fuelData = new FuelData();
            fuelData.setFuelType(fueltype);
            fuelData.setPrice(price);
            fuelData.setVolume(volume);
            fuelData.calculateTotal();
            fuelData.setDriverId(driverid);
            fuelData.setDate(dateSQL);
            return fuelData;
        //} catch (ParseException e) {
        //}
    }
}
