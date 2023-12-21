package com.bridgelabz.parkinglot.implementations;

import com.bridgelabz.parkinglot.ParkingLot;
import com.bridgelabz.parkinglot.interfaces.ParkingAttendant;
import com.bridgelabz.parkinglot.models.Car;

import java.util.ArrayList;
import java.util.List;


/*
    @desc: provides find nearest space and park
 */
public class NearestFreeSpaceParkingAttendant implements ParkingAttendant {
    private static List<Boolean> lotSpaces = new ArrayList<>();

    /*
        @desc: constructor of class
        @params: capacity
        @return: none
     */
    public NearestFreeSpaceParkingAttendant(int capacity){
        for(int i=0;i<capacity;i++){
            lotSpaces.add(i,true);
        }
    }

    /*
        @desc: override function for parkCar
        @params: parkinglot, car
        @return: void
     */
    @Override
    public void parkCar(ParkingLot parkingLot, Car car) {
        for (int i=0;i<lotSpaces.size();i++){
            if(lotSpaces.get(i)==true){
                parkingLot.parkCar(car);
                car.setLocation(i+1);
            }
        }
    }
}
