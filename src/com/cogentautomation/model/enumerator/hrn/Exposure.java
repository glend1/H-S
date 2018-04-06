package com.cogentautomation.model.enumerator.hrn;

import java.io.Serializable;

public enum Exposure implements Serializable {
	ANNUAL("Annually", 0.5), MONTHLY("Monthly", 1.0), WEEKLY("Weekly", 2.0), DAILY("Daily", 3.0), HOURLY("Hourly", 4.0), CONSTANTLY("Constantly", 5.0);
	
	private String name;
	private Double value;
	
	Exposure (String n, Double v) {
		setName(n);
		setValue(v);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	public String toString() {
		return getName();
	}
}
