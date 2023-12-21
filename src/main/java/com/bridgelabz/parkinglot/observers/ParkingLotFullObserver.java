package com.bridgelabz.parkinglot.observers;

import com.bridgelabz.parkinglot.ParkingLot;

import java.util.Observable;
import java.util.Observer;

/*
    @desc: observer class for checking occupancy
 */
public class ParkingLotFullObserver implements Observer{
    /*
        @desc: override function for update
        @params: parkinglot object
        @return: void
     */
    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof ParkingLot && ((ParkingLot) observable).isFull()) {
            System.out.println("Parking lot is full! Put out the full sign.");
        }
    }
}
