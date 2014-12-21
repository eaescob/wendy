package com.wendy.numberguess;

import java.security.SecureRandom;
import java.util.Scanner;

public class NumberGuess {
	private static final SecureRandom rnd = new SecureRandom();
	
	public static void main(String[] args) {
		String continueAnswer = "Y";
		Scanner scanner = new Scanner(System.in);
		
		while (continueAnswer.equalsIgnoreCase("Y")) {
			boolean answerCorrect = false;
			int numberGuesses = 0;
			int randomNumber = rnd.nextInt(1000);
			
			System.out.println("Guess a number between 1 - 1000");
			
			do {
				System.out.print("Please choose a number: ");
				int guess = scanner.nextInt();
				numberGuesses++;
				
				if (guess > randomNumber) {
					System.out.println("Too high. Try again");
				} else if (guess < randomNumber) {
					System.out.println("Too low. Try again");
				} else {
					answerCorrect = true;
					System.out.println("Congratulations. You guessed the number!");
					
					if (numberGuesses < 10) {
						System.out.println("Either you know the secret or you got lucky!");
					} else if (numberGuesses == 10) {
						System.out.println("Aha! You know the secret!");
					} else {
						System.out.println("You should be able to do better!");
					}
				}
				
			} while (answerCorrect == false);
			
			System.out.print("Would you like to play again (y/n)? ");
			continueAnswer = scanner.next();
		}
	}
}
