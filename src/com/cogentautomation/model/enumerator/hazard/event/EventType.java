package com.cogentautomation.model.enumerator.hazard.event;

import java.io.Serializable;

import com.cogentautomation.model.enumerator.hazard.generic.GenericType;

public enum EventType implements GenericType, Serializable {
	SHAPE("Shape and/or Superficial Finishing of Accessible Parts of the Machine"), MOVING("Moving Parts of the Machine"),
	KINETIC("Kinetic Energy and/or Gravity of the Machine, Parts of the Machine, Tools and Materials Used"), 
	STABILITY("Stability of the Machine and/or Parts of the Machine"),
	MECHANICAL("Mechanical Stiffness/Strength of Parts of the Machine, Tools, ect."), 
	HYDRAULIC("Pneumatic and Hydraulic Equipment"), ELECTRICAL("Electrical Equipment"), CONTROL("Control System"), 
	MATERIALS("Materials and Substances or Physical Factors (Temperature, Noise, Vibration, Radiation and Environment)"),
	WORKSTATION("Workstation and/or Work Process Design"), OTHER("Other Events");
	
	private String value;
	
	EventType(String value) {
		setValue(value);
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return getValue();
	}
}
