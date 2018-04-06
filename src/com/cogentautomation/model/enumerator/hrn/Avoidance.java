package com.cogentautomation.model.enumerator.hrn;

import java.io.Serializable;

public enum Avoidance implements Serializable {
	POSSIBLE("Possible", 0.75), CIRCUMSTANCES("Possible under certain circumstances", 2.5), NOTPOSSIBLE("Not possible", 5.0);
	
	private String name;
	private Double value;
	
	Avoidance(String n, Double i) {
		setName(n);
		setValue(i);
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return getName();
	}
}
