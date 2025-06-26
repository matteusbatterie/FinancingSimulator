package com.battery.financingsimulator.model;

/**
 * Represents a financing model for a house, extending the base Financing class
 * to include additional calculations specific to house financing, such as
 * insurance fees.
 */
public class House extends Financing {

	private static final double INSURANCE_FEE = 80.00;

	private final double builtArea;
	private final double landSize;

	public House(double propertyValue, int loanTermYears, double annualInterestRate, double builtArea,
			double landSize) {
		super(propertyValue, loanTermYears, annualInterestRate);

		this.builtArea = builtArea;
		this.landSize = landSize;
	}

	// Getters
	public double getBuiltArea() {
		return this.builtArea;
	}

	public double getLandSize() {
		return this.landSize;
	}

	/**
	 * Calculates the monthly payment for the house, including the base payment
	 * from the Financing class and an additional insurance fee.
	 *
	 * @return the total monthly payment including insurance
	 */
	@Override
	public double calculateMonthlyPayment() {
		double monthlyAmortization = this.getPropertyValue() / this.getLoanTermMonths();
		double monthlyInterestFactor = 1 + (this.getAnnualInterestRateDecimal() / 12.0);
		double basePayment = monthlyAmortization * monthlyInterestFactor;

		return basePayment + INSURANCE_FEE;
	}

	/**
	 * Returns a string representation of the house financing, including built area
	 * and land size.
	 *
	 * @return a formatted string with house financing details
	 */
	@Override
	public String toString() {
		String baseInfo = super.toString();
		String specificInfo = String.format(
				"Built Area: %.2f m²\n" +
						"Land Size: %.2f m²",
				this.getBuiltArea(),
				this.getLandSize());

		return baseInfo + "\n" + specificInfo;
	}
}