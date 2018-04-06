package com.cogentautomation.model.enumerator.hazard.task;

import java.io.Serializable;

import com.cogentautomation.model.enumerator.hazard.generic.GenericType;

public enum TaskType implements GenericType, Serializable {
	TRANSPORT("Transport"), ASSEMBLY("Assembly, Installation and Commissioning"), 
	SETTING("Setting, Teaching, Programming and/or Process Changeover"), OPERATION("Operation"), 
	CLEANING("Cleaning and Maintenance"), FAULTFINDING("Fault-finding/Trouble-shooting"), 
	DISMANTLING("Dismantling and Disabling");
	
	private String value;
	
	TaskType(String value) {
		setValue(value);
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String toString() {
		return getValue();
	}
}
