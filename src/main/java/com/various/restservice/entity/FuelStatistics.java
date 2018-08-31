package com.various.restservice.entity;

/**
 * Created by alex on 8/31/18.
 */
public class FuelStatistics {
        private String type;
        private String total;
        private long totalSum;

    public FuelStatistics(String type, Long total) {
        this.type = type;
        this.totalSum = total;
    }

    public String getType() {
        return type;
    }

    public String getTotal() {
        this.total = String.format ("%.02f", totalSum/100d);
        return total;
    }
}
