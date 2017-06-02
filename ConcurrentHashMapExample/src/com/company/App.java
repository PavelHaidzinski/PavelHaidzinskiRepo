package com.company;

/**
 * Created by Pavel_Haidzinski on 5/29/2017.
 */
public class App {
    public static final int NUM_OF_TRUCKS = 15;
    public static final Truck[] truckList = new Truck[App.NUM_OF_TRUCKS];

    public static int random(int m, int n){
        return (int)(Math.random()*(n - m + 1)) + m;
    }
}
