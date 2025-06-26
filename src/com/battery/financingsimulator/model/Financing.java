package com.battery.financingsimulator.model;

/**
 * Represents a financing model for a property, including calculations for
 * monthly payments and total payments based on the property value, loan term,
 * and annual interest rate.
 */
public class Financing {
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
	 * Calculates the monthly payment based on the property value, loan term, and
	 * annual interest rate. This is a simplified formula; real calculations would
	 * involve more complex interest calculations.
	 * 
	 * @return the monthly payment amount
	 */
	public double calculateMonthlyPayment() {
		double monthlyAmortization = this.getPropertyValue() / this.getLoanTermMonths();
		double monthlyInterestFactor = 1 + (this.getAnnualInterestRateDecimal() / 12.0);

		return monthlyAmortization * monthlyInterestFactor;
	}

	public double calculateTotalPayment() {
		return this.calculateMonthlyPayment() * this.getLoanTermMonths();
	}

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