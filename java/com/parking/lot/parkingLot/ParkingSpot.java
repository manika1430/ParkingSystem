package com.parking.lot.parkingLot;

public class ParkingSpot {
	
	Integer spotNumber;
	String spotSize;
	Boolean occupied;
	Integer levelNumber;
	
	public ParkingSpot(Integer spotNumber, String spotSize, Integer levelNumber) {
		this.spotNumber = spotNumber;
		this.spotSize = spotSize;
		this.levelNumber = levelNumber;
		this.occupied=false;
	}
	
	public Integer getSpotNumber() {
		return spotNumber;
	}
	public void setSpotNumber(Integer spotNumber) {
		this.spotNumber = spotNumber;
	}
	public String getSpotSize() {
		return spotSize;
	}
	public void setSpotSize(String spotSize) {
		this.spotSize = spotSize;
	}
	public Boolean isOccupied() {
		return occupied;
	}
	public void setOccupied(Boolean occupied) {
		this.occupied = occupied;
	}
	public Integer getLevelNumber() {
		return levelNumber;
	}
	public void setLevelNumber(Integer levelNumber) {
		this.levelNumber = levelNumber;
	}
	
	
	
	
	

}
