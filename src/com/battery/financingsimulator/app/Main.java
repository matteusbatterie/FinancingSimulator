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
						// For House, we need to mock built area and land size
						// as they are not provided by the user in this simulation.
						final double MOCKED_BUILT_AREA = 150.0;
						final double MOCKED_LAND_SIZE = 250.0;
						System.out.println("-> Using default values for built area and land size:");
						System.out.printf("Built Area: %.2f m², Land Size: %.2f m²%n", MOCKED_BUILT_AREA,
								MOCKED_LAND_SIZE);

						financings.add(
								new House(propertyValue, loanTerm, interestRate, MOCKED_BUILT_AREA, MOCKED_LAND_SIZE));
						break;
					case 2:
						// For Apartment, we need to mock parking spaces and floor number
						// as they are not provided by the user in this simulation.
						final int MOCKED_PARKING_SPACES = 2;
						final int MOCKED_FLOOR_NUMBER = 10;
						System.out.println("-> Using default values for parking spaces and floor number:");
						System.out.printf("Parking Spaces: %d, Floor Number: %d%n", MOCKED_PARKING_SPACES,
								MOCKED_FLOOR_NUMBER);

						financings.add(new Apartment(propertyValue, loanTerm, interestRate,
								MOCKED_PARKING_SPACES, MOCKED_FLOOR_NUMBER));
						break;
					case 3:

						System.out.println("-> Using default value for zone type (Residential).");
						financings.add(new Land(propertyValue, loanTerm, interestRate, ZoneType.RESIDENTIAL));
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