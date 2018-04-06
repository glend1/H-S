package com.cogentautomation.model.enumerator.hrn;

import java.io.Serializable;

public enum Likelihood implements Serializable {
	IMPOSSIBLE("Almost impossible", 0.5), UNLIKELY("Unlikely or Possible in extreme circumstances", 1.25), 
	POSSIBLE("Possible but unusual", 2.5), PROBABLE("Probable", 4.0), COULD("Even chance, it could happen", 5.0),
	LIKELY("Likely, only to be expected", 6.0), CERTAIN("Certain, no doubt it will happen", 7.0);
	
	private String name;
	private Double value;
	
	Likelihood (String n, Double v) {
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
