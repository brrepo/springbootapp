package com.various.restservice.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Acer on 28.08.2018.
 */
@Entity
public class FuelData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String fuelType;
    @Column(nullable = false)
    private String price;             // * 100  - two significant figures
    @Column(nullable = false)
    private String volume;            // * 100  - two significant figures
    @Column(nullable = false)
    private int total;             // * 100  - two significant figures
    @Column(nullable = false)
    private int transactionDay;    // 1 - 31  - two significant figures
    @Column(nullable = false)
    private int transactionMonth;  // 1 - 12  - two significant figures
    @Column(nullable = false)
    private int transactionYear;
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
        this.transactionDay = date.getDay();
        this.transactionMonth = date.getMonth() + 1;
        this.transactionYear = date.getYear() + 1900;
    }

    public void setDriverId(Integer driverId) {
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

    public Date getTransactionDate() {
        return new Date(this.transactionYear - 1900, this.transactionMonth - 1, this.transactionDay);
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void calculateTotal() {
        total = (getInt(price) * getInt(volume))/100;
    }

    private int getInt(String value){
        Double priceD = Double.valueOf(value)*100d;
        return priceD.intValue();
    }

    public int getTotal() {
        return total;
    }
}
