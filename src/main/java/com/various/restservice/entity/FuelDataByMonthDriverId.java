package com.various.restservice.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Acer on 28.08.2018.
 */
public class FuelDataByMonthDriverId {
    private String fuelType;
    private String price;
    private String volume;
    private String total;
    private String date;
    private Integer driverId;

    public FuelDataByMonthDriverId(String fuelType, String price, String volume, String total, String date, Integer driverId) {
        this.fuelType = fuelType;
        this.price = price;
        this.volume = volume;
        this.total = total;
        this.date = date;
        this.driverId = driverId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getPrice() {
        return price;
    }

    public String getVolume() {
        return volume;
    }

    public String getTotal() {
        return total;
    }

    public String getDate() {
        return date;
    }

    public Integer getDriverId() {
        return driverId;
    }
}
