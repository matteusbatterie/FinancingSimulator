package com.battery.financingsimulator.model;

/**
 * Represents a financing model for a house, extending the base Financing class
 * to include additional calculations specific to house financing, such as
 * insurance fees.
 */
public class House extends Financing {

	private static final double INSURANCE_FEE = 80.00;

	public House(double propertyValue, int loanTermYears, double annualInterestRate) {
		super(propertyValue, loanTermYears, annualInterestRate);
	}

	/**
	 * Calculates the monthly payment for the house, including the base payment
	 * from the Financing class and an additional insurance fee.
	 *
	 * @return the total monthly payment including insurance
	 */
	@Override
	public double calculateMonthlyPayment() {
		double basePayment = super.calculateMonthlyPayment();
		return basePayment + INSURANCE_FEE;
	}
}