package com.various.restservice.entity;

import com.various.restservice.Constants;

/**
 * Created by Acer on 28.08.2018.
 */
public class Money {
    private String total;


    public Money(double total) {
        this.total = String.format(Constants.FORMAT_DECIMAL, total);
    }

    public String getTotal() {
        return total;
    }
}
