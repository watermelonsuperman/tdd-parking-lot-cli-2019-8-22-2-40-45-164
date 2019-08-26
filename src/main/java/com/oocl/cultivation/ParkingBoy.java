package com.oocl.cultivation;

import java.util.Map;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
    	
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
    	if(parkingLot.getAvailableParkingPosition() > 0){
        	lastErrorMessage = null;
    	}else{
    		lastErrorMessage = "The parking lot is full.";
    	}
       return  parkingLot.park(car);
    }

    public Car fetch(ParkingTicket ticket) {
    	if(parkingLot.getCars().containsKey(ticket)){
    		lastErrorMessage = null;
    	}else if(ticket == null){
    		lastErrorMessage = "Please provide your parking ticket.";
    	}else{
    		lastErrorMessage = "Unrecognized parking ticket.";
    	}
        return parkingLot.fetch(ticket);
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
