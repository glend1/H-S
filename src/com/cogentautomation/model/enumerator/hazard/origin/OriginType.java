package com.cogentautomation.model.enumerator.hazard.origin;

import java.io.Serializable;

import com.cogentautomation.model.enumerator.hazard.generic.GenericType;

public enum OriginType implements GenericType, Serializable {
	MECHANICAL("Mechanical"), ELECTRICAL("Electrical"), THERMAL("Thermal"), NOISE("Noise"), VIBRATION("Vibration"), 
	RADIATION("Radiation"), MATERIAL("Material/Substance"), ERGONOMIC("Ergonomic"), ENVIROMENTAL("Enviromental");
	
	private String value;
	
	OriginType(String value) {
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
