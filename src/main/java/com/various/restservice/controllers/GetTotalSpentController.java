package com.various.restservice.controllers;

import com.various.restservice.repository.FuelDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Acer on 23.08.2018.
 */
@RestController
public class GetTotalSpentController {

    @Autowired
    private FuelDataRepository fuelDataRepository;

    @GetMapping("/totalspent")
    public String getTotalSpent(){
        return String.valueOf(fuelDataRepository.count());
    }
}
