package com.battery.financingsimulator.app;

import java.util.ArrayList;
import java.util.List;

import com.battery.financingsimulator.model.*;
import com.battery.financingsimulator.ui.UserInputHandler;

/**
 * The main entry point for the Financing Simulator application.
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("### Welcome to the Financing Simulator ###");
		UserInputHandler ui = new UserInputHandler();
		List<Financing> financings = new ArrayList<>();

		while (true) {
			System.out.println("\nSelect an option:");
			System.out.println("0. Display All Simulations & Exit");
			System.out.println("1. Simulate House Financing");
			System.out.println("2. Simulate Apartment Financing");
			System.out.println("3. Simulate Land Financing");

			int choice = ui.readInt("Enter your choice: ");

			if (choice == 0) {
				break;
			}

			try {
				double propertyValue = ui.askPropertyValue();
				int loanTerm = ui.askLoanTerm();
				double interestRate = ui.askInterestRate();

				switch (choice) {
					case 1:
						financings.add(new House(propertyValue, loanTerm, interestRate));
						break;
					case 2:
						financings.add(new Apartment(propertyValue, loanTerm, interestRate));
						break;
					case 3:
						financings.add(new Land(propertyValue, loanTerm, interestRate));
						break;
					default:
						System.out.println("Invalid option. Please try again.");
						continue;
				}

				System.out.println("Financing added successfully!");
			} catch (IllegalArgumentException e) {
				System.out.println("\nError creating financing: " + e.getMessage());
				System.out.println("Please try again.");
			}
		}

		double totalPropertyValue = 0;
		double totalFinancingCost = 0;

		System.out.println("\n--- SIMULATION RESULTS ---");
		for (Financing f : financings) {
			System.out.println("\n------------------------------");
			System.out.println(f);

			totalPropertyValue += f.getPropertyValue();
			totalFinancingCost += f.calculateTotalPayment();
		}

		System.out.println("\n==============================");
		System.out.printf("Total Property Value: $%,.2f%n", totalPropertyValue);
		System.out.printf("Total Financing Cost (valid only): $%,.2f%n", totalFinancingCost);
		System.out.println("==============================");

		ui.close();
		System.out.println("\nSimulator finished.");
	}
}