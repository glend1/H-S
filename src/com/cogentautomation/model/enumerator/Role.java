package com.cogentautomation.model.enumerator;

import java.io.Serializable;

public enum Role implements Serializable {
	ASSESSOR("Assessor"), REVIEWER("Reviewer"), CLIENT("Client");
	
	private String name;
	
	private Role (String n) {
		name = n;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
