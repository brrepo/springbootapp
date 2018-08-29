package com.various.restservice.entity;

import javax.persistence.*;
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

    @Column(nullable = false)
    private String fuelType;
    @Column(nullable = false)
    private String price;
    @Column(nullable = false)
    private String volume;
    @Column(nullable = false)
    private Date transactionDate;
    @Column(nullable = false)
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
        this.transactionDate = date;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }
}
