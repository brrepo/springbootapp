package com.various.restservice.entity;

import javax.persistence.*;
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
    private String price;
    @Column(nullable = false)
    private String volume;
    @Column(nullable = false)
    private int volumeInt;            // * 100  - two significant figures
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
        calculateTotal();
    }

    public void setVolume(String volume) {

        this.volume = volume;
        calculateTotal();
    }

    public void setDate(Date date) {
        this.transactionDay = date.getDate();
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

    public int getTransactionMonth() {
        return transactionMonth;
    }

    public int getTransactionYear() {
        return transactionYear;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void calculateTotal() {
        if( volume != null)  volumeInt = getInt(volume);
        if (price!=null) total = (int) (getInt(price) * volumeInt) / 100;
    }

    private int getInt(String value) {
        Double priceD = Double.valueOf(value) * 100d;
        return priceD.intValue();
    }

    public int getTotal() {
        return total;
    }

    public int getVolumeInt() {
        return volumeInt;
    }
}
