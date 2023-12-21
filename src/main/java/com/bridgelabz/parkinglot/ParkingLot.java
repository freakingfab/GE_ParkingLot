package com.bridgelabz.parkinglot;

import java.util.*;
import com.bridgelabz.parkinglot.interfaces.ParkingAttendant;
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

    /*
        @desc: function to check plot has space or not
        @params: none
        @return: boolean
     */
    public boolean hasSpace() {
        return parkedCars.size() < capacity;
    }

    /*
        @desc: getter for List of parked cars
        @params: none
        @return: Map<car>
     */
    public Map<Integer,Integer> getParkedCars() {
        return new HashMap<>(parkedCars);
    }

    /*
        @desc: getter for capacity variable
        @params: none
        @return: int
     */
    public int getCapacity() {
        return capacity;
    }

    /*
        @desc: park cars with attendant
        @params: List<Cars>, attendant
        @return: void
     */
    public void parkCarsWithAttendant(List<Car> cars, ParkingAttendant attendant) {
        for (Car car : cars) {
            attendant.parkCar(this, car, car.getCarId());
        }
    }
}
