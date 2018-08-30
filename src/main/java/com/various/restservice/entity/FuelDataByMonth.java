package com.various.restservice.entity;

/**
 * Created by Acer on 28.08.2018.
 */
public class FuelDataByMonth {
    private String fuelType;
    private String price;
    private String volume;
    private String total;
    private String date;

    public FuelDataByMonth(String fuelType, String price, String volume, String total, String date, Integer driverId) {
        this.fuelType = fuelType;
        this.price = price;
        this.volume = volume;
        this.total = total;
        this.date = date;
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

}
