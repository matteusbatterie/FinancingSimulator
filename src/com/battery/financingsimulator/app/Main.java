package com.battery.financingsimulator.app;

import com.battery.financingsimulator.model.*;
import com.battery.financingsimulator.ui.UserInputHandler;

/**
 * The main entry point for the Financing Simulator application.
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("### Welcome to the Financing Simulator ###");

		UserInputHandler inputHandler = new UserInputHandler();

		double propertyValue = inputHandler.askPropertyValue();
		int loanTerm = inputHandler.askLoanTerm();
		double interestRate = inputHandler.askInterestRate();

		Financing financing = new Financing(propertyValue, loanTerm, interestRate);

		System.out.println("\n--- FINANCING DETAILS ---");
		System.out.println(financing);

		inputHandler.closeScanner();
	}
}