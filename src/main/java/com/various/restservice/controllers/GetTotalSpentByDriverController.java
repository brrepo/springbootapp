package com.various.restservice.controllers;

import com.various.restservice.entity.FuelData;
import com.various.restservice.entity.Money;
import com.various.restservice.repository.FuelDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

import static com.various.restservice.utils.Checker.check;

/**
 * Created by Acer on 23.08.2018.
 */
@RestController
public class GetTotalSpentByDriverController {

    @Autowired
    private FuelDataRepository fuelDataRepository;

    @GetMapping("/totalspentbydriver")
    public Money getTotalSpent(
            @RequestParam int month,
            @RequestParam int year,
            @RequestParam int driverId
    ) {
        check(month, year, driverId);
        List <FuelData> in = fuelDataRepository.findByTransactionYearEqualsAndTransactionMonthEqualsAndDriverIdEquals(year, month, driverId);
        int sum = in.stream().mapToInt(FuelData::getTotal).sum();
        return new Money(sum/100d);
    }
}
