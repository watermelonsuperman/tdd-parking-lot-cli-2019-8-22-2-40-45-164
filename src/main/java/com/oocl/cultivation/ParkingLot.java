package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<ParkingTicket, Car> cars = new HashMap<>();

    public Map getCars(){
    	return cars;
    }
    public ParkingLot() {
        this(10);
    }
    
    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableParkingPosition() {
        return capacity - cars.size();
    }
    public ParkingTicket park(Car car){
    	
    	ParkingTicket parkingTicket = new ParkingTicket();
    	if(capacity - cars.size() > 0){
    	parkingTicket.car = car ;
    	cars.put(parkingTicket, car);
    	}else{
    		parkingTicket = null;
    	}
    	return parkingTicket;
    }
    public Car fetch(ParkingTicket parkingTicket){
    	
    	Car car = new Car();
    	car = cars.get(parkingTicket);
    	if(cars.get(parkingTicket) == null){
    		return null;
    	}
    	cars.remove(parkingTicket);
    	return car;
    }
}
