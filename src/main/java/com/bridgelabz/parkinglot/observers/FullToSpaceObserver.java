package com.bridgelabz.parkinglot.observers;

import com.bridgelabz.parkinglot.ParkingLot;

import java.util.Observable;
import java.util.Observer;

/*
    @desc: Observer for notifying when a full parking lot gets space
 */
public class FullToSpaceObserver implements Observer {
    private boolean wasFull = false;

    @Override
    public void update(Observable o, Object arg) {
        ParkingLot parkingLot = (ParkingLot) o;
        boolean isFull = parkingLot.isFull();

        if (wasFull && !isFull) {
            System.out.println("Parking lot has space again. Take in the full sign.");
        }

        wasFull = isFull;
    }
}
