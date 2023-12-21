package com.bridgelabz.parkinglot.implementations;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import com.bridgelabz.parkinglot.ParkingLot;
import com.bridgelabz.parkinglot.interfaces.ParkingAttendant;
import com.bridgelabz.parkinglot.models.Car;

/*
    @desc: attendant which follows evenly distribution
 */
public class EvenDistributionParkingAttendant implements ParkingAttendant {
    private static Map<Integer, Integer> lotUsageCount = new HashMap<>();
    /*
        @desc: constructor for class
        @params: capacity of plot
        @return: none
     */
    public EvenDistributionParkingAttendant(int capacity){
        for(int i=1;i<=capacity;i++){
            lotUsageCount.put(i,0);
        }
    }
    /*
        @desc: override function for parkCar
        @params: parking lot, car
        @return: void
     */
    @Override
    public void parkCar(ParkingLot parkingLot, Car car) {
        int minUsageLot = Collections.min(lotUsageCount.entrySet(), Map.Entry.comparingByValue()).getKey();
        parkingLot.parkCar(car);
        car.setLocation(minUsageLot);
        lotUsageCount.put(minUsageLot, lotUsageCount.get(minUsageLot) + 1);
    }
}
