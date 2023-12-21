package com.bridgelabz.parkinglot;

import java.util.*;
import java.util.stream.Collectors;

import com.bridgelabz.parkinglot.interfaces.ParkingAttendant;
import com.bridgelabz.parkinglot.models.Car;

/*
    @desc: class for the whole parking lot
 */
public class ParkingLot extends Observable{
    private int capacity;
    private Map<Integer, Car> parkedCars;

    private static final int perHourCharge = 5;

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
    public void parkCar(Car car){
        if(getParkingPlotOccupancy() < capacity){
            parkedCars.put(car.getCarId(), car);
            System.out.println("Car parked: "+car.getCarId());
            setChanged();
            notifyObservers();
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
        @return: List<car>
     */
    public List<Car> getParkedCars() {
        List<Car> cars = new ArrayList<>();
        for(int i=0;i<parkedCars.size();i++){
            cars.add(parkedCars.get(i+1));
        }
        return cars;
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
            attendant.parkCar(this, car);
        }
    }

    /*
        @desc: provides location for car
        @params: carId
        @return: int
     */
    public int getLocationOfCar(int carId){
        return parkedCars.get(carId).getLocation();
    }

    /*
        @desc: provides charge for parking
        @param: carId, currentTime
        @return: int
     */
    public int getParkingCharge(int carId, int currentTime){
        return (currentTime - parkedCars.get(carId).getEntryTime())*perHourCharge;
    }


}
