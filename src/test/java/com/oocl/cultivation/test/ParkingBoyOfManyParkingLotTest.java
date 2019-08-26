package com.oocl.cultivation.test;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;

public class ParkingBoyOfManyParkingLotTest {
	
	//假设停车男孩有两个停车场,当第一个停车场已满时,停车男孩会把车停在第二个停车场
	@Test
	public void should_part_at_the_other_parkingLot_when_the_parkingLot_is_full(){
		//given
		List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>(); 
		ParkingLot parkingLot1 = new ParkingLot(0);
		ParkingLot parkingLot2 = new ParkingLot(2);
		parkingLotList.add(parkingLot1);
		parkingLotList.add(parkingLot2);
		ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
		Car car = new Car();
		
		//when
		ParkingTicket ticket = parkingBoy.parkToManyParingLot(car);
		
		//then
		assertNotNull(ticket);
		assertEquals(1,parkingLotList.get(1).getAvailableParkingPosition());
	}
}
