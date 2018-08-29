package com.various.restservice.controllers;

import com.various.restservice.entity.FuelData;
import com.various.restservice.interactors.FuelDataInteractor;
import com.various.restservice.interactors.FuelDataInteractorImpl;
import com.various.restservice.repository.FuelDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Acer on 23.08.2018.
 */
@RestController
public class GetTotalSpentController {

    @Autowired
    private FuelDataRepository fuelDataRepository;

    @GetMapping("/totalspent")
    public List<FuelData> getTotalSpent(
            @RequestParam int month,
            @RequestParam int year
    ) {
        if (month < 1 || month > 12 || year < 1980 || year > 2200) throw new IllegalArgumentException("Month or year are invalid");

        Calendar start = Calendar.getInstance();
        Calendar end;
        start.clear(Calendar.HOUR_OF_DAY);
        start.clear(Calendar.MINUTE);
        start.clear(Calendar.SECOND);
        start.clear(Calendar.MILLISECOND);
        start.set(Calendar.DAY_OF_MONTH, 1);
        start.set(Calendar.MONTH, month - 1);
        start.set(Calendar.YEAR, 1);
        end = (Calendar) start.clone();
        end.add(Calendar.MONTH, 1);
        end.add(Calendar.MILLISECOND, -1);

        Date date = new Date(2018-1900, 7-1, 1);
        //return fuelDataRepository.findAll();
        //return fuelDataRepository.findByTransactionDateIsAfterAndTransactionDateIsBefore(date , new Date());
        Iterator iter = fuelDataRepository.findByTransactionYearEqualsAndTransactionMonthEquals(2018 , 7).iterator();
        
        return fuelDataRepository.findByTransactionYearEqualsAndTransactionMonthEquals(2018 , 7);
    }
}
