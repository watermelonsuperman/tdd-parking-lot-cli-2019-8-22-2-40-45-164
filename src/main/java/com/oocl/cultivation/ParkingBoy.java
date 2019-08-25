package com.oocl.cultivation;

import java.util.Map;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
    	
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
       return  parkingLot.park(car);
    }

    public Car fetch(ParkingTicket ticket) {
    	Map map = parkingLot.getCars();
    	if(map.containsKey(ticket)){
    		lastErrorMessage = null;
    	}else{
    		lastErrorMessage = "Unrecognized parking ticket.";
    	}
        return parkingLot.fetch(ticket);
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
