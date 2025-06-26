package com.battery.financingsimulator.model;

/**
 * Represents a financing model for an apartment.
 * This class overrides the base financing calculation to use the
 * standard PRICE amortization formula.
 */
public class Apartment extends Financing {

	private final int parkingSpaces;
	private final int floorNumber;

	public Apartment(double propertyValue, int loanTermYears, double annualInterestRate, int parkingSpaces,
			int floorNumber) {
		super(propertyValue, loanTermYears, annualInterestRate);

		this.parkingSpaces = parkingSpaces;
		this.floorNumber = floorNumber;
	}

	// Getters
	public int getParkingSpaces() {
		return this.parkingSpaces;
	}

	public int getFloorNumber() {
		return this.floorNumber;
	}

	/**
	 * Calculates the monthly payment for the apartment financing using the PRICE
	 * amortization formula.
	 *
	 * @return The calculated monthly payment.
	 */
	@Override
	public double calculateMonthlyPayment() {
		double propertyValue = this.getPropertyValue();
		double monthlyRate = this.getAnnualInterestRateDecimal() / 12.0;
		int months = this.getLoanTermMonths();

		return this.calculatePriceFormula(propertyValue, monthlyRate, months);
	}

	/**
	 * Calculates the monthly payment using the standard PRICE amortization formula.
	 * This is a private helper method to keep the public API clean.
	 *
	 * @param propertyValue The total value of the property.
	 * @param monthlyRate   The monthly interest rate in decimal format.
	 * @param months        The total number of months for the loan.
	 * @return The calculated monthly payment.
	 */
	private double calculatePriceFormula(double propertyValue, double monthlyRate, int months) {
		// It represents the compounding effect of the interest rate over the loan term.
		// It is used to calculate the total amount to be paid in interest and
		// principal.
		double compoundingFactor = Math.pow(1 + monthlyRate, months);

		// Standard PRICE formula: P * [i * (1+i)^n] / [(1+i)^n - 1]
		double numerator = propertyValue * monthlyRate * compoundingFactor;
		double denominator = compoundingFactor - 1;

		return numerator / denominator;
	}

	@Override
	public String toString() {
		String baseInfo = super.toString();
		String specificInfo = String.format("Parking Spaces: %d\n" +
				"Floor Number: %d",
				this.getParkingSpaces(),
				this.getFloorNumber());

		return baseInfo + "\n" + specificInfo;
	}
}
