package com.company;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHashMapExample {

    public static void main(String[] args) {

        for(int i = 0; i < App.NUM_OF_TRUCKS; i ++){
            App.truckList[i] = new Truck(App.random(1000, 5000 ));
        }

        //Create NUM_OF_TRUCKS Threads
        ExecutorService executorService = Executors.newFixedThreadPool(App.NUM_OF_TRUCKS);
        //Create number of trucks callables with random operations (ARRIVAL or DEPARTURE)
        DistributionCenterTruckQueue[] distributionCenterTruckQueue = new DistributionCenterTruckQueue[App.NUM_OF_TRUCKS];
        for(int i = 0; i < App.NUM_OF_TRUCKS; i++){
            distributionCenterTruckQueue[i] = new DistributionCenterTruckQueue(App.truckList[i], DistributionCenterTruckQueue.OPERATION.values()[App.random(0, 1)]);
        }
        //Execute the callables and get the result of each operation
        for(int i = 0; i < App.NUM_OF_TRUCKS; i++ ){
            try{
                App.truckList[i] = executorService.submit(distributionCenterTruckQueue[i]).get();
                System.out.println(App.truckList[i]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        for(int i = 0; i < App.NUM_OF_TRUCKS; i ++){
            try{
                distributionCenterTruckQueue[i] = new DistributionCenterTruckQueue(App.truckList[i], DistributionCenterTruckQueue.OPERATION.INPROGRESS);
                Truck truck = executorService.submit(distributionCenterTruckQueue[i]).get();
                System.out.println(truck.isInprogress() ? truck + ": True" : truck + ": False");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }

}
