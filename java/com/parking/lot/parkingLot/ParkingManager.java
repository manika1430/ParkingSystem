package com.parking.lot.parkingLot;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManager {
	
	private static ParkingManager instance;
	List<ParkingLevel>parkingLevels= new ArrayList<ParkingLevel>();
	Integer NumberOfLevels=2;
	Map<String,Integer>perMinuteCharge=new HashMap<String,Integer>();	
	
	Map<String,ParkingVehicle> parkedVehicles=new HashMap<String,ParkingVehicle>();
	
	private ParkingManager() {
	// Create parkingLot
		createParkingLot();
		
	}
	
	private void createParkingLot() {
	     //create level in parking lot
		for(int i=0;i<NumberOfLevels;i++) {
			ParkingLevel pl= new ParkingLevel();
			List<ParkingSpot> psList=new ArrayList<ParkingSpot>();
			//Create Parking spot for each level
			psList.add(new ParkingSpot(0,"Small",i));
			psList.add(new ParkingSpot(1,"Small",i));
			psList.add(new ParkingSpot(2,"Small",i));
			psList.add(new ParkingSpot(3,"Small",i));
			psList.add(new ParkingSpot(4,"Medium",i));
			psList.add(new ParkingSpot(5,"Medium",i));
			psList.add(new ParkingSpot(6,"Medium",i));
			psList.add(new ParkingSpot(7,"Medium",i));
			psList.add(new ParkingSpot(8,"Large",i));
			psList.add(new ParkingSpot(9,"Large",i));
			psList.add(new ParkingSpot(10,"Large",i));
			
			pl.setLevelNumber(i);
			pl.setSpotLists(psList);
			
			parkingLevels.add(pl);
	
		}
		
		//Add per hour charge
		perMinuteCharge.put("Small",20);
		perMinuteCharge.put("Large",100);
		perMinuteCharge.put("Medium",50);

		
	}

	public static ParkingManager getInstance() {
		if(instance==null)
			instance=new ParkingManager();
		return instance;
	}
	
	
	public boolean parkVehicle(String vehicleNumber, String vehicleSize) {
		
		ParkingVehicle vehicle= new ParkingVehicle();
		vehicle.setVehicleNumber(vehicleNumber);
		vehicle.setVehicleType(vehicleSize);
		
		ParkingSpot parkingSpot=null;
		for(ParkingLevel pl:parkingLevels) {
			List<ParkingSpot> psList=pl.getSpotLists();
			for(ParkingSpot ps:psList) {
				if(!ps.isOccupied() && (ps.getSpotSize().equalsIgnoreCase(vehicle.getVehicleType()))) {
					parkingSpot=ps;
					break;
				}
						
			}
		}
		
		if(parkingSpot==null)
			return false;
		
		parkingSpot.setOccupied(true);
		vehicle.setEntryTime(new Date());
		vehicle.setSpotAssigned(String.valueOf(parkingSpot.getLevelNumber())+" "+String.valueOf(parkingSpot.getSpotNumber()));
		System.out.println("Parked at "+vehicle.getSpotAssigned());
		parkedVehicles.put(vehicleNumber,vehicle);
		return true;
		
	}
	
	public Integer calculateFeesForCheckout(String vehicleNumber, String vehicleSize) {
		
		if(parkedVehicles.get(vehicleNumber)==null) {
			return 0;
		}
		
		ParkingVehicle vehicle=parkedVehicles.get(vehicleNumber);
		//park out the vehicle
		String spotAssigned=vehicle.getSpotAssigned();
		System.out.println("Spot is ->"+spotAssigned);
		int level=Integer.valueOf(spotAssigned.split(" ")[0]);
		int spotNumber=Integer.valueOf(spotAssigned.split(" ")[1]);
		parkingLevels.get(level).getSpotLists().get(spotNumber).setOccupied(false);
		parkedVehicles.remove(vehicleNumber);
		
		//calculate fees
		long currTime= System.currentTimeMillis();
		long prevTime=vehicle.getEntryTime().getTime();
		
		int diff=(int)(currTime-prevTime)/(1000*60);
		
		if(diff>0) {
			return diff*perMinuteCharge.get(vehicleSize);
		}
		
		return perMinuteCharge.get(vehicleSize);
		
	}
	
	
	
	

}
