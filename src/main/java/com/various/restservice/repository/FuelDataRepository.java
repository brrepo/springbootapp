package com.various.restservice.repository;

import com.various.restservice.entity.FuelData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Acer on 28.08.2018.
 */

public interface FuelDataRepository extends JpaRepository<FuelData, Integer> {
    List<FuelData> findAll();
    List<FuelData> findByTransactionYearEqualsAndTransactionMonthEquals(int year, int month);
    List<FuelData> findByTransactionYearEqualsAndTransactionMonthEqualsAndDriverIdEquals(int year, int month, int driverId);
}
