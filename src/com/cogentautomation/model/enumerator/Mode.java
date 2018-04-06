package com.cogentautomation.model.enumerator;

import java.io.Serializable;

public enum Mode implements Serializable {
	PRODUCTION("Production"), NONPRODUCTION("Non-Production"), OTHER("Other");
	
	private String name;
	
	private Mode (String n) {
		name = n;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
