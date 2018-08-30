package com.various.restservice.entity;

/**
 * Created by Acer on 28.08.2018.
 */
public class Money {
    private String total;


    public Money(double total) {
        this.total = String.format("%.02f", total);
    }

    public String getTotal() {
        return total;
    }
}
