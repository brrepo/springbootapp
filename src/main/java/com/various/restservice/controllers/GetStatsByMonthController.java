package com.various.restservice.controllers;

import com.various.restservice.entity.FuelData;
import com.various.restservice.entity.FuelDataByMonth;
import com.various.restservice.entity.FuelStatistics;
import com.various.restservice.repository.FuelDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.various.restservice.utils.Checker.check;

/**
 * Created by Acer on 23.08.2018.
 */
@RestController
public class GetStatsByMonthController {

    @Autowired
    private FuelDataRepository fuelDataRepository;

    @GetMapping("/statsbymonth")
    public List<FuelStatistics> getFuelStatistics(
            @RequestParam int month,
            @RequestParam int year
    ) {
        check(month, year);
        List <FuelStatistics> out = fuelDataRepository.findFuelStatistics(year, month);
        return out;
    }
}
