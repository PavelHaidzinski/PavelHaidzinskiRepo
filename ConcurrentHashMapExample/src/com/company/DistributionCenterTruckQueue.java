package com.company;

import java.util.concurrent.Callable;

/**
 * Created by Pavel_Haidzinski on 5/29/2017.
 */
public class DistributionCenterTruckQueue implements Callable<Truck> {

    public static enum OPERATION {ARRIAVAL, DEPARTURE, INPROGRESS}

    private IDistributionCenterVehicleService<Truck> truckService;
    private Truck vehicle;
    private OPERATION operation;

    public DistributionCenterTruckQueue(){}

    public DistributionCenterTruckQueue(Truck vehicle, OPERATION operation){
        this.vehicle = vehicle;
        this.operation = operation;
        this.truckService = new DistributionCenterTruckService();
    }

    @Override
    public Truck call() throws Exception {

        switch(this.operation){
            case ARRIAVAL:
                System.out.println("Arriving: ");
                this.truckService.arrivalQueue(this.vehicle);
                break;
            case DEPARTURE:
                System.out.println("Departing: ");
                this.truckService.departureQueue(this.vehicle);
                break;
            case INPROGRESS:
                System.out.println("IN Progress: ");
                this.vehicle.setInprogress(this.truckService.unloadInProgress(this.vehicle));
                break;
        }
        return this.vehicle;
    }
}
