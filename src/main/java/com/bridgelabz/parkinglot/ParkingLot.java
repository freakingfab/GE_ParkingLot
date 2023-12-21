package com.bridgelabz.parkinglot;

import java.util.*;

/*
    @desc: class for the whole parking lot
 */
public class ParkingLot extends Observable{
    private int capacity;
    private Map<Integer, Integer> parkedCars;

    /*
        @desc: constructor for class
        @params: capacity
        @return: none
     */
    public ParkingLot(int capacity){
        this.capacity = capacity;
        parkedCars = new HashMap<>();
    }

    /*
        @desc: getter for parking lot list size
        @params: none
        @return: int
     */
    public int getParkingPlotOccupancy(){
        return parkedCars.size();
    }

    /*
        @desc: function to provide parking facility
        @params: Car object
        @return: void
     */
    public void parkCar(Car car, int location){
        if(getParkingPlotOccupancy() < capacity){
            parkedCars.put(car.getCarId(), location);
            System.out.println("Car parked: "+car.getCarId());
            setChanged();
            notifyObservers();
        }
        else{
            System.out.println("Parking Lot is full");
        }
    }

    /*
        @desc: function to provide unparking facility
        @params: car object id
        @return: void
     */
    public void unparkCar(int carId){
        if(parkedCars.containsKey(carId)){
            parkedCars.remove(carId);
            System.out.println("Car Unparked: " + carId);
            setChanged();
            notifyObservers();
        }
        else{
            System.out.println("No such car found");
        }
    }

    /*
        @desc: function to check full occupancy
        @params: none
        @return: boolean
     */
    public boolean isFull() {
        return parkedCars.size() >= capacity;
    }
}
