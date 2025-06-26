package com.battery.financingsimulator.model;

/**
 * Enum representing different types of zones for properties.
 * Each zone type has a description associated with it.
 */
public enum ZoneType {
	RESIDENTIAL("Residencial"),
	COMMERCIAL("Comercial");

	private final String description;

	ZoneType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}