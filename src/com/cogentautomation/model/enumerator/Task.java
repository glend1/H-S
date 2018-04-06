package com.cogentautomation.model.enumerator;

import java.io.Serializable;

public enum Task implements Serializable {
	NORMAL("Normal"), ABNORMAL("Abnormal"), OTHER("Other");
	
	private String name;
	
	private Task (String n) {
		name = n;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
