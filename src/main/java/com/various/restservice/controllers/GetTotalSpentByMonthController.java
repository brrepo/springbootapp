package com.various.restservice.controllers;

import com.various.restservice.entity.FuelData;
import com.various.restservice.entity.Money;
import com.various.restservice.interactors.FuelDataInteractor;
import com.various.restservice.interactors.FuelDataInteractorImpl;
import com.various.restservice.repository.FuelDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Acer on 23.08.2018.
 */
@RestController
public class GetTotalSpentByMonthController {

    @Autowired
    private FuelDataRepository fuelDataRepository;

    @GetMapping("/totalspent")
    public Money getTotalSpent(
            @RequestParam int month,
            @RequestParam int year
    ) {
        if (month < 1 || month > 12 || year < 1980 || year > 2200) throw new IllegalArgumentException("Month or year are invalid");
        List <FuelData> in = fuelDataRepository.findByTransactionYearEqualsAndTransactionMonthEquals(year, month);
        int sum = in.stream().mapToInt(FuelData::getTotal).sum();
        return new Money(sum/100d);
    }
}
