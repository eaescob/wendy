package com.wendy.airline;

import java.util.Scanner;

public class ReservationSystem {
	private static final int PLANE_CAPACITY = 10;
	private static boolean[] seatMapping = new boolean[PLANE_CAPACITY];
	
	static {
		for (int x = 0; x < seatMapping.length; x++)
			seatMapping[x] = false;
	}
	
	public static String getMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("1. Reserve first class seat\n");
		sb.append("2. Reserve economy seat\n");
		sb.append("3. Exit\n");
		sb.append("Please select an option: ");
		return sb.toString();
	}
	
	public static void reserveFirstClass(boolean upgrade, Scanner scanner) {
		int freeSeat = 0;
		boolean seatFound = false;
		for(int x = 0; x < 5; x++) {
			if (!seatMapping[x]) {
				seatFound = true;
				freeSeat = x;
				break;
			}
		}
		
		if (!seatFound) {
			if (upgrade) {
				System.out.println("Plane is full. Next flight leaves in 3 hours");
				return;
			}
			
			System.out.print("First class full, would you like to reserve economy (y/n)? ");
			String userAnswer = scanner.next();
			
			if (userAnswer.equalsIgnoreCase("y")) {
				reserveEconomy(true, scanner);
			} else {
				System.out.println("Next flight leaves in 3 hours");
			}
		} else {
			seatMapping[freeSeat] = true;
			System.out.printf("First class seat number %d reserved%n", freeSeat+1);
		}
	}
	
	public static void reserveEconomy(boolean downgrade, Scanner scanner) {
		boolean seatFound = false;
		int freeSeat = 0;
		
		for (int x = 5; x < PLANE_CAPACITY; x++) {
			if (!seatMapping[x]) {
				seatFound = true;
				freeSeat = x;
				break;
			}
		}
		
		if (!seatFound) {
			if (downgrade) {
				System.out.println("Plane is full. Next flight leaves in 3 hours");
				return;
			}
			
			System.out.print("Economy class is full, would you like to reserve first class (y/n)? ");
			String userChoice = scanner.next();
			
			if (userChoice.equalsIgnoreCase("y")) {
				reserveFirstClass(true, scanner);
			} else {
				System.out.println("Next flight leaves in 3 hours");
			}
		} else {
			seatMapping[freeSeat] = true;
			System.out.printf("Economy class seat number %d reserved%n", freeSeat+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int userChoice = 0;
		
		System.out.println("Emilio's Airline Reservation System Copyright (c) 2014\n");
		
		do {
			System.out.println(getMenu());
			userChoice = scanner.nextInt();
			
			switch(userChoice) {
			case 1: reserveFirstClass(false, scanner);
					break;
			case 2: reserveEconomy(false, scanner);
					break;
			case 3: break; //program will exit
			default: System.out.println("Invalid option " + userChoice);
			}
		} while (userChoice != 3);
		
	}
}
