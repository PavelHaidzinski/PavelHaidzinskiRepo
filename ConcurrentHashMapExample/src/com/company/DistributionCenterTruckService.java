package com.company;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by Pavel_Haidzinski on 5/29/2017.
 */
public class DistributionCenterTruckService implements IDistributionCenterVehicleService<Truck> {

    private static final ConcurrentMap<Truck, Long> vehicleQueue = new ConcurrentHashMap<>();

    @Override
    public void arrivalQueue(Truck vehicle) {
        long currentTime = System.currentTimeMillis();
        DistributionCenterTruckService.vehicleQueue.putIfAbsent(vehicle, currentTime);
    }

    @Override
    public boolean unloadInProgress(Truck vehicle) {
        return DistributionCenterTruckService.vehicleQueue.get(vehicle)!=null;
    }

    @Override
    public void departureQueue(Truck vehicle) {
        DistributionCenterTruckService.vehicleQueue.remove(vehicle);
    }
}
