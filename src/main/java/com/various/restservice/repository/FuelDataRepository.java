package com.various.restservice.repository;

import com.various.restservice.entity.FuelData;
import com.various.restservice.entity.FuelStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by Acer on 28.08.2018.
 */

public interface FuelDataRepository extends JpaRepository<FuelData, Integer> {
    List<FuelData> findAll();
    List<FuelData> findByTransactionYearEqualsAndTransactionMonthEquals(int year, int month);
    List<FuelData> findByTransactionYearEqualsAndTransactionMonthEqualsAndDriverIdEquals(int year, int month, int driverId);

    @Query("SELECT " +
            "    new com.various.restservice.entity.FuelStatistics(v.fuelType, sum(v.total), sum(v.volumeInt)) " +
            "FROM " +
            "    FuelData v " +
            "WHERE v.transactionYear = :year AND v.transactionMonth =  :month " +
            "GROUP BY " +
            "    v.fuelType")
    List<FuelStatistics> findFuelStatistics(@Param("year") int year, @Param("month") int month);

}
