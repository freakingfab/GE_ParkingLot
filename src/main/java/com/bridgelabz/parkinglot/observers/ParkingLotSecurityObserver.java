package com.bridgelabz.parkinglot.observers;

import com.bridgelabz.parkinglot.ParkingLot;

import java.util.Observable;
import java.util.Observer;

/*
    @desc: observer class for checking occupancy by airport security
 */
public class ParkingLotSecurityObserver implements Observer{
    /*
        @desc: override function for update
        @params: observable and arg
        @return: void
     */
    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof ParkingLot && ((ParkingLot) observable).isFull()) {
            System.out.println("Security staff redirected. Parking lot is full!");
        }
    }
}
