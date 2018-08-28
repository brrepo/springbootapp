package com.various.restservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by Acer on 28.08.2018.
 */
@Entity
public class FuelData {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String fuelType;

    private String price;
    private String volume;
    private Date date;
    private Integer driverId;

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }
}
