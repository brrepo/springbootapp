package com.various.restservice.entity;

import com.various.restservice.Constants;

import java.text.SimpleDateFormat;

/**
 * Created by Acer on 28.08.2018.
 */
public class FuelDataByMonth {
    private String fuelType;
    private String price;
    private String volume;
    private String total;
    private String date;
    private SimpleDateFormat sdf = new SimpleDateFormat(Constants.FORMAT_DATE);

    public FuelDataByMonth(FuelData data) {
        this.fuelType = data.getFuelType();
        this.price = data.getPrice();
        this.volume = data.getVolume();
        this.total = String.format(Constants.FORMAT_DECIMAL, data.getTotal() / 100d);
        this.date = sdf.format(data.getTransactionDate());
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
