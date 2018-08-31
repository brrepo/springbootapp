package com.various.restservice.controllers;

import com.various.restservice.entity.FuelStatistics;
import com.various.restservice.repository.FuelDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.various.restservice.utils.Checker.check;

/**
 * Created by Acer on 23.08.2018.
 */
@RestController
public class GetStatsByMonthDriverController {

    @Autowired
    private FuelDataRepository fuelDataRepository;

    @GetMapping("/statsbymonthdriver")
    public List<FuelStatistics> getFuelStatistics(
            @RequestParam int month,
            @RequestParam int year,
            @RequestParam int driverId
    ) {
        check(month, year, driverId);
        List <FuelStatistics> out = fuelDataRepository.findFuelStatistics(year, month, driverId);
        return out;
    }
}
