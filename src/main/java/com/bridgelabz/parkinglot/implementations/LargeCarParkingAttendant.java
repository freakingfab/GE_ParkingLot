package com.bridgelabz.parkinglot.implementations;

import com.bridgelabz.parkinglot.ParkingLot;
import com.bridgelabz.parkinglot.interfaces.ParkingAttendant;
import com.bridgelabz.parkinglot.models.Car;

import java.util.*;

/*
    @desc: give row for largest car parking space available
 */
public class LargeCarParkingAttendant implements ParkingAttendant {
    private static Map<Integer, Integer> lotSpace = new HashMap<>();

    /*
        @desc: constructor for class
        @params: no of row, lot in each row
        @return: none
     */
    public LargeCarParkingAttendant(int noOfRow, int lotInEachRow){
        for(int i=0;i<noOfRow;i++){
            lotSpace.put(i,lotInEachRow);
        }
    }

    /*
        @desc: overiride function for parkCar
        @params: parkinglot, car
        @return: void
     */
    @Override
    public void parkCar(ParkingLot parkingLot, Car car){
        int maxFreeSpaceLot = -1;
        int maxFreeSpace = Integer.MIN_VALUE;
        for(int i=0;i<lotSpace.size();i++){
            int count = lotSpace.get(i);
            if(count>maxFreeSpace){
                maxFreeSpace = count;
                maxFreeSpaceLot = i;
            }
        }
        parkingLot.parkCar(car);
        int ascii = (int) 'A';
        car.setLocation(ascii + maxFreeSpaceLot);
    }
}
