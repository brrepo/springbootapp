package com.various.restservice.repository;

import com.various.restservice.entity.FuelData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Acer on 28.08.2018.
 */

public interface FuelDataRepository extends JpaRepository<FuelData, Integer> {

    List<FuelData> findByTransactionDateIsAfterAndTransactionDateIsBefore(Date dateStart, Date dateEnd);
}
