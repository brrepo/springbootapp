package com.various.restservice.entity;

import com.various.restservice.Constants;

/**
 * Created by alex on 8/31/18.
 */
public class FuelStatistics {
        private String type;
        private String total;
        private String volume;
        private String average;
        private long totalSum;
        private long volumeSum;

    public FuelStatistics(String type, long total, long volume) {
        this.type = type;
        this.totalSum = total;
        this.volumeSum = volume;
    }

    public String getType() {
        return type;
    }

    public String getTotal() {
        this.total = String.format (Constants.FORMAT_DECIMAL, totalSum/100d);
        return total;
    }

    public String getVolume() {
        this.volume = String.format (Constants.FORMAT_DECIMAL, volumeSum/100d);
        return volume;
    }

    public String getAverage() {
        Double averageCalculated = ((double) totalSum) /((double)volumeSum);
        this.average = String.format (Constants.FORMAT_DECIMAL, averageCalculated);
        return average;
    }
}
