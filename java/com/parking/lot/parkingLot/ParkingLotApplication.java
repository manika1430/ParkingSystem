package com.parking.lot.parkingLot;

import java.util.Scanner;

public class ParkingLotApplication {

	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);
		ParkingManager parkingManager=ParkingManager.getInstance();
		while(true) {
			System.out.println("******Press 1 to park in a vehicle**********");
			System.out.println("******Press 2 to check out a vehicle********");
			
	        String func = scanner.nextLine();
	        if((Integer.valueOf(func)!=1 && Integer.valueOf(func)!=2)){
	        	System.out.println("Inavlid input!!! Try again");
	        	continue;
	        }
			System.out.println("******Enter vehicle number********");
			String vehicleNumber=scanner.nextLine();
			System.out.println("******Enter vehicle size********");
			String vehicleSize=scanner.nextLine();
			if(Integer.valueOf(func)==1) {
				try {
					boolean result=parkingManager.parkVehicle(vehicleNumber, vehicleSize);
					if(result) {
						System.out.println("Vehicle number "+ vehicleNumber +" parked successfullyy!!!!");
					}else {
						System.out.println("Vehicle number "+ vehicleNumber +" could not be parked. Please wait for sometime");
						
					}
				} catch(Exception e) {
					System.out.println("Exception while parking Vehicle number "+ vehicleNumber + " "+ e.getMessage());
				}
				
			}else if(Integer.valueOf(func)==2) {
				
				try {
					int amount=parkingManager.calculateFeesForCheckout(vehicleNumber, vehicleSize);
					System.out.println("Please pay rupees "+ amount);
				} catch (Exception e) {
					System.out.println("Exception checking out vehicle "+vehicleNumber + " "+ e.getMessage());
				}

			}
			
		}
		
	}

}
