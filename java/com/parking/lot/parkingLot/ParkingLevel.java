package com.parking.lot.parkingLot;

import java.util.List;

public class ParkingLevel {
	
	Integer levelNumber;
	List<ParkingSpot>spotLists;

	
	public Integer getLevelNumber() {
		return levelNumber;
	}
	public void setLevelNumber(Integer levelNumber) {
		this.levelNumber = levelNumber;
	}
	public List<ParkingSpot> getSpotLists() {
		return spotLists;
	}
	public void setSpotLists(List<ParkingSpot> spots) {
		this.spotLists = spots;
	}
	
	

}
