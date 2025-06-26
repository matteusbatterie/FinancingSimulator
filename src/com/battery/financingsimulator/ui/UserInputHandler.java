package com.battery.financingsimulator.ui;

import java.util.InputMismatchException;
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
	 * Closes the scanner to release resources.
	 */
	public void close() {
		scanner.close();
	}

	/**
	 * Prompts the user to enter the property value.
	 * 
	 * @return the property value entered by the user
	 */
	public double askPropertyValue() {
		return readDouble("Enter the property value: $");
	}

	/**
	 * Prompts the user to enter the loan term in years.
	 * 
	 * @return the loan term in years entered by the user
	 */
	public int askLoanTerm() {
		return readInt("Enter the loan term (in years): ");
	}

	/**
	 * Prompts the user to enter the annual interest rate.
	 * 
	 * @return the annual interest rate entered by the user
	 */
	public double askInterestRate() {
		return readDouble("Enter the annual interest rate (%): ");
	}

	/**
	 * Reads a double value from the user with a prompt.
	 * 
	 * @param prompt the message to display to the user
	 * @return the double value entered by the user
	 */
	public double readDouble(String prompt) {
		while (true) {
			System.out.print(prompt);
			try {
				return scanner.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				scanner.next();
			}
		}
	}

	/**
	 * Reads an integer value from the user with a prompt.
	 * 
	 * @param prompt the message to display to the user
	 * @return the integer value entered by the user
	 */
	public int readInt(String prompt) {
		while (true) {
			System.out.print(prompt);
			try {
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter an integer.");
				scanner.next();
			}
		}
	}
}