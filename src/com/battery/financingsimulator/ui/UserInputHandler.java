package com.battery.financingsimulator.ui;

import java.util.Scanner;

/**
 * Handles user input from the console.
 */
public class UserInputHandler {
	private final Scanner scanner;

	public UserInputHandler() {
		this.scanner = new Scanner(System.in);
	}

	/**
	 * Prompts the user to enter the property value.
	 * 
	 * @return the property value entered by the user
	 */
	public double askPropertyValue() {
		System.out.print("Enter the property value: $");
		return scanner.nextDouble();
	}

	/**
	 * Prompts the user to enter the loan term in years.
	 * 
	 * @return the loan term in years entered by the user
	 */
	public int askLoanTerm() {
		System.out.print("Enter the loan term (in years): ");
		return scanner.nextInt();
	}

	/**
	 * Prompts the user to enter the annual interest rate.
	 * 
	 * @return the annual interest rate entered by the user
	 */
	public double askInterestRate() {
		System.out.print("Enter the annual interest rate (%): ");
		return scanner.nextDouble();
	}

	public void closeScanner() {
		scanner.close();
	}
}