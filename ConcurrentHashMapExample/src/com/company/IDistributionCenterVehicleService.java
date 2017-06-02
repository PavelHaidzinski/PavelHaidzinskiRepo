package com.company;

/**
 * Created by Pavel_Haidzinski on 5/29/2017.
 */
public interface IDistributionCenterVehicleService<T> {

    public void arrivalQueue(T vehicle);
    public boolean unloadInProgress(T vehicle);
    public void departureQueue(T vehicle);
}
