package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingBoy {

    private ParkingLot parkingLot;
    private String lastErrorMessage;
	private List<ParkingLot> parkingLotList; 

    
    public ParkingBoy(ParkingLot parkingLot) {
    	
        this.parkingLot = parkingLot;
    }
    

    public ParkingBoy(List<ParkingLot> parkingLotList) {
    	this.parkingLotList = parkingLotList;
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
    public List getParkingLotList(){
    	return parkingLotList;
    }
    //可以停放到多个停车场
    public ParkingTicket parkToManyParingLot(Car car){
    	ParkingLot parkLot = new ParkingLot();
    	ParkingTicket tiket = new ParkingTicket();
    	for(int i = 0;i<parkingLotList.size();i++){
    		if(parkingLotList.get(i).getAvailableParkingPosition()>0){
    			parkLot = parkingLotList.get(i);
    			break;
    		}
    	}
    	return parkLot.park(car);
    }
}
