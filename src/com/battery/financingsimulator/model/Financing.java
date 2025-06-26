package com.battery.financingsimulator.model;

/**
 * Represents a financing model for properties, serving as a base class for
 * specific financing types like House and Land. This class encapsulates common
 * properties and methods related to property financing.
 */
public abstract class Financing {

	private final double propertyValue;
	private final int loanTermYears;
	private final double annualInterestRate;

	public Financing(double propertyValue, int loanTermYears, double annualInterestRate) {
		this.propertyValue = propertyValue;
		this.loanTermYears = loanTermYears;
		this.annualInterestRate = annualInterestRate;
	}

	// Getters
	public double getPropertyValue() {
		return this.propertyValue;
	}

	public int getLoanTermYears() {
		return this.loanTermYears;
	}

	public double getAnnualInterestRate() {
		return this.annualInterestRate;
	}

	public int getLoanTermMonths() {
		return this.loanTermYears * 12;
	}

	public double getAnnualInterestRateDecimal() {
		return this.annualInterestRate / 100.0;
	}

	/**
	 * Abstract method to calculate the monthly payment for the financing model.
	 * This method must be implemented by subclasses to provide specific payment
	 * calculations.
	 *
	 * @return The calculated monthly payment.
	 */
	public abstract double calculateMonthlyPayment();

	public double calculateTotalPayment() {
		return this.calculateMonthlyPayment() * this.getLoanTermMonths();
	}

	/**
	 * Returns a string representation of the financing model, including property
	 * value, total payment, and monthly payment.
	 *
	 * @return A formatted string with financing details.
	 */
	@Override
	public String toString() {
		return String.format("Property Value: $%,.2f\n" +
				"Total Payment: $%,.2f\n" +
				"Monthly Payment: $%,.2f",
				this.getPropertyValue(),
				this.calculateTotalPayment(),
				this.calculateMonthlyPayment());
	}
}