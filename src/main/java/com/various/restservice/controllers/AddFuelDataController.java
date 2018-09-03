package com.various.restservice.controllers;

import com.various.restservice.Constants;
import com.various.restservice.entity.FuelData;
import com.various.restservice.interactors.FuelDataInteractor;
import com.various.restservice.interactors.FuelDataInteractorImpl;
import com.various.restservice.repository.FuelDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * Created by Acer on 23.08.2018.
 */
@RestController
public class AddFuelDataController {

    @Autowired
    private FuelDataRepository fuelDataRepository;

    @PostMapping(Constants.ADDFUELDATA)
    public void addFuelData (
            @RequestParam String fueltype,
            @RequestParam String price,
            @RequestParam String volume,
            @RequestParam String date,     //mm.dd.yyyy
            @RequestParam int driverid) throws ParseException {
        FuelDataInteractor interactor = new FuelDataInteractorImpl();
        FuelData fuelData = interactor.getFuelData(fueltype, price, volume, date, driverid);
        fuelDataRepository.save(fuelData);
    }

    @ExceptionHandler
    public String databaseError() {
        return "databaseError";
    }
}
