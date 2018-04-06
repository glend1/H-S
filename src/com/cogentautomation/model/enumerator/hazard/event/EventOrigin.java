package com.cogentautomation.model.enumerator.hazard.event;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cogentautomation.model.enumerator.hazard.generic.GenericOrigin;

public enum EventOrigin implements GenericOrigin, Serializable {
	
	ROUGH(Arrays.asList(EventType.SHAPE), "Contact with Rough Surfaces"),
	SHARP(Arrays.asList(EventType.SHAPE), "Contact with Sharp Edges and Corners, Protuding Parts"),
	
	MOVING(Arrays.asList(EventType.MOVING), "Contact with Moving Parts"),
	ROTATING(Arrays.asList(EventType.MOVING), "Contact with Rotating Open Ends"),

	FALLING(Arrays.asList(EventType.KINETIC), "Falling or Ejection of Objects"),
	
	STABILITY(Arrays.asList(EventType.STABILITY), "Loss of Stability"),

	DEFLECTION(Arrays.asList(EventType.MECHANICAL), "Deflection or Break-up During Operation"),
	
	DISPLACEMENT(Arrays.asList(EventType.HYDRAULIC), "Displacement of Moving Elements"),
	HIGHPRESSURE(Arrays.asList(EventType.HYDRAULIC), "Projection of High-pressure Fluids"),
	
	CONTACT(Arrays.asList(EventType.ELECTRICAL), "Direct Contact"),
	DISCHARGE(Arrays.asList(EventType.ELECTRICAL), "Distruptive Discharge"),
	ARC(Arrays.asList(EventType.ELECTRICAL), "Electrical Arc"),
	FIRE(Arrays.asList(EventType.ELECTRICAL), "Fire"),
	INDIRECT(Arrays.asList(EventType.ELECTRICAL), "Indirect Contact"),
	SHORT(Arrays.asList(EventType.ELECTRICAL), "Short-circuit"),
	
	DROPPING(Arrays.asList(EventType.CONTROL), "Dropping or Ejection of Moving Parts of the Machine or of a "
			+ "Workpiece Clamped by the Machine"),
	MOVINGPARTS(Arrays.asList(EventType.CONTROL), "Failure to Stop Moving Parts"),
	ACTION(Arrays.asList(EventType.CONTROL), "Machine Action Resulting from Inhibition (Defeating or "
			+ "Failure) of Protective Devices"),
	UNINTENDED(Arrays.asList(EventType.CONTROL), "Unintended/Unexpected start-up"),
	OTHERCONTROL(Arrays.asList(EventType.CONTROL), "Other Hazardous Events due to Failures(s) or Poor Design of the "
			+ "Control System"),
	
	TEMPERATURE(Arrays.asList(EventType.MATERIALS), "Contact with Objects with High or Low Temperature"),
	SUBSTANCE(Arrays.asList(EventType.MATERIALS), "Emission of a Substance that can be Hazardous"),
	NOISELEVEL(Arrays.asList(EventType.MATERIALS), "Emission of a Level of Noise that can be Hazardous"),
	NOISEINTERFERANCE(Arrays.asList(EventType.MATERIALS), "Emission of a level of noise that can be Interfere with "
			+ "Speech Communication or with Acoustic Signals"),
	VIBRATION(Arrays.asList(EventType.MATERIALS), "Emission of a level of Vibration that can be Hazardous"),
	RADIATION(Arrays.asList(EventType.MATERIALS), "Emission of Radiation Fields that can be Hazardous"),
	ENVIRONMENT(Arrays.asList(EventType.MATERIALS), "Harsh Environmental Conditions"),
	
	EFFORT(Arrays.asList(EventType.WORKSTATION), "Excessive Effort"),
	HUMANERROR(Arrays.asList(EventType.WORKSTATION), "Human Errors/Misbehaviour (Unintentional and/or Deliberately Induced "
			+ "by the Design"),
	VISIBILITY(Arrays.asList(EventType.WORKSTATION), "Loss of Direct Visibility of the Working Area"),
	POSTURE(Arrays.asList(EventType.WORKSTATION), "Painful and/or Tiring Postures"),
	REPETATIVE(Arrays.asList(EventType.WORKSTATION), "Repetative Handling at High Frequency"),
	
	OTHER(Arrays.asList(EventType.OTHER), "Other Events"),
	
	UNCONTROLLED(Arrays.asList(EventType.HYDRAULIC, EventType.CONTROL), "Uncontrolled Movements");
	
	private List<EventType> types;
	private String value;
	
	public List<EventType> getTypes() {
		return types;
	}

	public void setTypes(List<EventType> types) {
		this.types = types;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public static List<EventOrigin> getValues(EventType et) {
		List<EventOrigin> vals = new ArrayList<EventOrigin>();
		for (EventOrigin eo: values()) {
			for (EventType val: eo.getTypes()) {
				if (val == et) {
					vals.add(eo);
				}
			}
		}
		return vals;
	}

	EventOrigin (List<EventType> types, String value) {
		setTypes(types);
		setValue(value);
	}
	
	@Override
	public String toString() {
		return getValue();
	}
}
