package com.battery.financingsimulator.model;

/**
 * Represents a financing model for land, extending the base Financing class.
 * This class is used to simulate financing for land properties.
 */
public class Land extends Financing {

	private static final double RISK_SURCHARGE_FACTOR = 1.02;

	public Land(double propertyValue, int loanTermYears, double annualInterestRate) {
		super(propertyValue, loanTermYears, annualInterestRate);
	}

	/**
	 * This method overrides the base class method to apply a risk surcharge factor
	 * specific to land financing.
	 *
	 * @return The calculated monthly payment with risk surcharge.
	 */
	@Override
	public double calculateMonthlyPayment() {
		double monthlyAmortization = this.getPropertyValue() / this.getLoanTermMonths();
		double monthlyInterestFactor = 1 + (this.getAnnualInterestRateDecimal() / 12.0);
		double basePayment = monthlyAmortization * monthlyInterestFactor;

		return basePayment * RISK_SURCHARGE_FACTOR;
	}
}
