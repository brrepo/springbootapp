package com.various.restservice.controllers;

import com.various.restservice.interactors.FuelDataInteractor;
import com.various.restservice.interactors.FuelDataInteractorImpl;
import com.various.restservice.repository.FuelDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Acer on 23.08.2018.
 */
@RestController
public class AddFuelDataController {
    @Autowired
    private FuelDataRepository fuelDataRepository;

    @PostMapping("/addfueldata")
    public String addFuelData(
            @RequestParam String fueltype,
            @RequestParam String price,
            @RequestParam String volume,
            @RequestParam String date,     //mm.dd.yyyy
            @RequestParam int driverid) {
        FuelDataInteractor interactor = new FuelDataInteractorImpl();
        interactor.getFuelData(fueltype, price, volume, date, driverid)
                .subscribe(fuelData -> {
                return ;}, error -> {
                return ;});
    }
}
