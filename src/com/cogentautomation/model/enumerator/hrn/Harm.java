package com.cogentautomation.model.enumerator.hrn;

import java.io.Serializable;

public enum Harm implements Serializable {
	SCRATCH("Scratch or Bruise", 0.25), LACERATION("Laceration, Mild ill health effect, Minor burn", 0.5), 
	MINORBONE("Break of a minor bone (finger or toe) or Minor temporary illness", 3.0), 
	MAJORBONE("Break of a major bone (leg, arm and above) or major permanent illness", 5.0), 
	MAJORBURN("Loss of 1 or 2 fingers/toes or major burns", 8.0), 
	SINGLEAMPUTATION("Amputation of 1 hand, arm or leg, loss of 1 eye or partial hearing loss", 11.0),
	MULTIPLEAMPUTATION("Amputation of 2 hands, arms or legs, Total loss of both eyes or Total hearing loss", 15.0),
	CRITICALINDURIES("Critical injuries or Permanent condition or Illness", 25.0), 
	FATALITY("Single fatality", 40.0), MULTIPLEFATALITY("Multiple fatalities", 65.0);
	
	private String name;
	private Double value;
	
	Harm (String n, Double v) {
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
