package com.parking.lot.parkingLot;

import java.util.Date;

public class ParkingVehicle {
	
	String vehicleNumber;
	String vehicleType;
	Date entryTime;
	String spotAssigned;
	
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public Date getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
	public String getSpotAssigned() {
		return spotAssigned;
	}
	public void setSpotAssigned(String spotAssigned) {
		this.spotAssigned = spotAssigned;
	}
	
	
}
