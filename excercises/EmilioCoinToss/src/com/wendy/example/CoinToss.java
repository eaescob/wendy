package com.wendy.example;

import java.security.SecureRandom;
import java.util.Scanner;

public class CoinToss {
	private static enum Coin { HEADS, TAILS };
	private static SecureRandom rnd = new SecureRandom("Wendy, I love you".getBytes());
	
	private static Coin flip() {
		int value = rnd.nextInt(10);
		
		if (value % 2 == 0)
			return Coin.HEADS;
		else
			return Coin.TAILS;
	}
	
	private static void showMenu() {
		StringBuilder builder = new StringBuilder();
		builder.append("Coin Toss Menu:\n" +
		"\t 1. Coss Toin\n" + 
		"\t 2. Show Results\n" +
		"\t 3. Exit\n"
		);
		
		System.out.printf("%s", builder.toString());
	}
	
	public static void main(String[] args) {
		int option = 0;
		int heads = 0, tails = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		do {
			showMenu();
			System.out.print("Enter option: ");
			option = scanner.nextInt();
			
			switch(option) {
				case 1:
					Coin result = flip();
					if (result == Coin.HEADS) {
						System.out.println("Got heads!");
						heads++;
					} else {
						System.out.println("Got tails!");
						tails++;
					}
					break;
				case 2:
					System.out.printf("Total heads: %d%nTotal tails: %d%n", heads, tails);
					break;
				case 3: break; //Do nothing as we will exit
				
				default: System.out.printf("Invalid option %d, try again!%n", option);
			}
			
		} while (option != 3);
	}
	
	
}
