package com.cogentautomation.model.enumerator;

import java.io.Serializable;

public enum HazardSelection implements Serializable {
	NOTCONSIDERED("Not Considered"), NOTAPPLICABLE("Not Applicable"), CONSIDERED("Considered"), HAZARD("Hazard");
	
	private String name;
	
	private HazardSelection (String n) {
		name = n;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
