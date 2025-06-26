package com.battery.financingsimulator.model;

/**
 * Represents a financing model for land, extending the base Financing class.
 * This class is used to simulate financing for land properties.
 */
public class Land extends Financing {

	private static final double RISK_SURCHARGE_FACTOR = 1.02;

	private final ZoneType zoneType;

	public Land(double propertyValue, int loanTermYears, double annualInterestRate, ZoneType zoneType) {
		super(propertyValue, loanTermYears, annualInterestRate);
		this.zoneType = zoneType;
	}

	// Getters
	public ZoneType getZoneType() {
		return this.zoneType;
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

	@Override
	public String toString() {
		String baseInfo = super.toString();
		String specificInfo = String.format(
				"Zone Type: %s",
				this.getZoneType().getDescription());

		return baseInfo + "\n" + specificInfo;
	}
}
