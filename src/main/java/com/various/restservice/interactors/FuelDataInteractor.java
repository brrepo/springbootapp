package com.various.restservice.interactors;

import com.various.restservice.entity.FuelData;
import io.reactivex.Single;

/**
 * Created by Acer on 28.08.2018.
 */
public abstract class FuelDataInteractor {
    public abstract Single<FuelData> getFuelData(
            String fueltype,
            String price,
            String volume,
            String date,     //mm.dd.yyyy
            int driverid
    );
}
