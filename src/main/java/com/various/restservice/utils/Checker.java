package com.various.restservice.utils;

/**
 * Created by alex on 8/31/18.
 */
public class Checker {


    public static void check( int month, int year, int driverId) {
        check (month, year);
        if (driverId < 0 ) throw new IllegalArgumentException("driverId is invalid");
    }

    public static void check( int month, int year) {
        if (month < 1 || month > 12 || year < 1980 || year > 2200) throw new IllegalArgumentException("Month or year are invalid");
    }
}
