package com.cogentautomation.model.enumerator.hazard.origin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cogentautomation.model.enumerator.hazard.generic.GenericOrigin;

public enum OriginOrigin implements GenericOrigin, Serializable {
	ACCELERATION(Arrays.asList(OriginType.MECHANICAL), "Acceleration/Deceleration"),
	KINETIC(Arrays.asList(OriginType.MECHANICAL), "Kinetic Energy"),
	ANGULAR(Arrays.asList(OriginType.MECHANICAL), "Angular Parts"),
	APPROACH(Arrays.asList(OriginType.MECHANICAL), "Approach of a Moving Element to a Fixed Part"),
	CUTTING(Arrays.asList(OriginType.MECHANICAL), "Cutting Parts"),
	ELASTIC(Arrays.asList(OriginType.MECHANICAL), "Elastic Elements"),
	FALLING(Arrays.asList(OriginType.MECHANICAL), "Falling Objects"),
	GRAVITY(Arrays.asList(OriginType.MECHANICAL), "Gravity"),
	STORED(Arrays.asList(OriginType.MECHANICAL), "Stored Energy"),
	HEIGHT(Arrays.asList(OriginType.MECHANICAL), "Height from the Ground"),
	PRESSURE(Arrays.asList(OriginType.MECHANICAL), "High Pressure"),
	MOBILITY(Arrays.asList(OriginType.MECHANICAL), "Machinery Mobility"),
	MOVING(Arrays.asList(OriginType.MECHANICAL), "Moving Elements"),
	ROTATING(Arrays.asList(OriginType.MECHANICAL), "Rotating Elements"),
	SURFACEFINISH(Arrays.asList(OriginType.MECHANICAL), "Surface Finish (Rough or Slippery)"),
	SHARP(Arrays.asList(OriginType.MECHANICAL), "Sharp Edges"),
	INSTABILITY(Arrays.asList(OriginType.MECHANICAL), "Instability"),
	VACUUM(Arrays.asList(OriginType.MECHANICAL), "Vacuum"),
	
	ARC(Arrays.asList(OriginType.ELECTRICAL), "Arc"),
	ELECTROMAGNETIC(Arrays.asList(OriginType.ELECTRICAL), "Electromagnetic Phenomena"),
	ELECTROSTATIC(Arrays.asList(OriginType.ELECTRICAL), "Electrostatic Phenomena"),
	LIVEPARTS(Arrays.asList(OriginType.ELECTRICAL), "Live Parts"),
	HIGHVOLTAGE(Arrays.asList(OriginType.ELECTRICAL), "Insufficient Distance from Live Parts under High Voltage"),
	OVERLOAD(Arrays.asList(OriginType.ELECTRICAL), "Overload"),
	LIVEFAULT(Arrays.asList(OriginType.ELECTRICAL), "Parts Becoming Live under Fault Conditions"),
	SHORTCIRCUIT(Arrays.asList(OriginType.ELECTRICAL), "Short Circuit"),
	TERMALRADIATION(Arrays.asList(OriginType.ELECTRICAL), "Thermal Radiation"),
	
	EXPLOSION(Arrays.asList(OriginType.THERMAL), "Explosion"),
	FLAME(Arrays.asList(OriginType.THERMAL), "Flame"),
	MATERIALTEMPERATURE(Arrays.asList(OriginType.THERMAL), "Objects or Materials with a High or Low Temperature"),
	RADIATIONHEAT(Arrays.asList(OriginType.THERMAL), "Radiation from heat sources"),
	
	EXHAUST(Arrays.asList(OriginType.NOISE), "Exhaust System"),
	GASLEAK(Arrays.asList(OriginType.NOISE), "High Speed Gas Leak"),
	MANUFACTURING(Arrays.asList(OriginType.NOISE), "Manufacturing Process"),
	MOVINGPARTS(Arrays.asList(OriginType.NOISE), "Moving Parts"),
	ROTATINGPARTS(Arrays.asList(OriginType.NOISE), "Unbalanced Rotating Parts"),
	PNEUMATICS(Arrays.asList(OriginType.NOISE), "Whistling Pneumatics"),	
	
	MISALIGNMENT(Arrays.asList(OriginType.VIBRATION), "Misalignment of moving parts"),
	MOBILEEQUIPMENT(Arrays.asList(OriginType.VIBRATION), "Mobile Equipment"),
	UNBALANCEDROTATING(Arrays.asList(OriginType.VIBRATION), "Unbalanced Rotating Parts"),
	VIBRATING(Arrays.asList(OriginType.VIBRATION), "Vibrating Equipment"),
	
	IONISING(Arrays.asList(OriginType.RADIATION), "Ionising radiation source"),
	ELECTROMAGNETICRADIATION(Arrays.asList(OriginType.RADIATION), "Low-frequency Electromagnetic Radiation"),
	OPTICAL(Arrays.asList(OriginType.RADIATION), "Optical Radiation (Infrared, Visible and Ultraviolet), including Laser"),
	RADIO(Arrays.asList(OriginType.RADIATION), "Radio Frequency Electromagnetic Radiation"),
	
	AEROSOL(Arrays.asList(OriginType.MATERIAL), "Aerosol"),
	BIOLOGICAL(Arrays.asList(OriginType.MATERIAL), "Biological and Microbiological (Viral or Bacterial) Agent"),
	COMBUSTIBLE(Arrays.asList(OriginType.MATERIAL), "Combustible"),
	DUST(Arrays.asList(OriginType.MATERIAL), "Dust"),
	EXPLOSIVE(Arrays.asList(OriginType.MATERIAL), "Explosive"),
	FIBRE(Arrays.asList(OriginType.MATERIAL), "Fibre"),
	FLAMMABLE(Arrays.asList(OriginType.MATERIAL), "Flammable"),
	FLUID(Arrays.asList(OriginType.MATERIAL), "Fluid"),
	FUME(Arrays.asList(OriginType.MATERIAL), "Fume"),
	GAS(Arrays.asList(OriginType.MATERIAL), "Gas"),
	MIST(Arrays.asList(OriginType.MATERIAL), "Mist"),
	OXIDISER(Arrays.asList(OriginType.MATERIAL), "Oxidiser"),
	
	ACCESS(Arrays.asList(OriginType.ERGONOMIC), "Access"),
	DISPLAYUNITS(Arrays.asList(OriginType.ERGONOMIC), "Design or Location of Indicators and Visual Display Units"),
	CONTROLDEVICES(Arrays.asList(OriginType.ERGONOMIC), "Design, Location or Identification of Control Devices"),
	EFFORT(Arrays.asList(OriginType.ERGONOMIC), "Effort"),
	LIGHTINGDISTRACTION(Arrays.asList(OriginType.ERGONOMIC), "Flicker, Dazzling, Shadow, Stroboscopic effect"),
	LOCALLIGHTING(Arrays.asList(OriginType.ERGONOMIC), "Local Lighting"),
	MENTAL(Arrays.asList(OriginType.ERGONOMIC), "Mental Overload or Underload"),
	POSTURE(Arrays.asList(OriginType.ERGONOMIC), "Posture"),
	REPETATIVE(Arrays.asList(OriginType.ERGONOMIC), "Repetitive Activity"),
	VISIBILITY(Arrays.asList(OriginType.ERGONOMIC), "Visibility"),
	
	FOG(Arrays.asList(OriginType.ENVIROMENTAL), "Dust and fog"),
	ELECTROMAGNETICDISTURBANCE(Arrays.asList(OriginType.ENVIROMENTAL), "Electromagnetic disturbance"),
	LIGHTING(Arrays.asList(OriginType.ENVIROMENTAL), "Lighting"),
	MOISTURE(Arrays.asList(OriginType.ENVIROMENTAL), "Moisture"),
	POLLUTION(Arrays.asList(OriginType.ENVIROMENTAL), "Pollution"),
	SNOW(Arrays.asList(OriginType.ENVIROMENTAL), "Snow"),
	TEMPERATURE(Arrays.asList(OriginType.ENVIROMENTAL), "Temperature"),
	WATER(Arrays.asList(OriginType.ENVIROMENTAL), "Water"),
	WIND(Arrays.asList(OriginType.ENVIROMENTAL), "Wind"),
	OXYGEN(Arrays.asList(OriginType.ENVIROMENTAL), "Lack of Oxygen"),
	
	WORN(Arrays.asList(OriginType.VIBRATION, OriginType.NOISE), "Worn Parts"),
	SCRAPINGSURFACES(Arrays.asList(OriginType.VIBRATION, OriginType.NOISE), "Scraping Surfaces"),
	CAVITATION(Arrays.asList(OriginType.VIBRATION, OriginType.NOISE), "Cavitation Phenomena"),
	OTHER(Arrays.asList(OriginType.ELECTRICAL, OriginType.ENVIROMENTAL, OriginType.ERGONOMIC, OriginType.MATERIAL, 
			OriginType.MECHANICAL, OriginType.NOISE, OriginType.RADIATION, OriginType.THERMAL, OriginType.VIBRATION), "Other");
	
	private List<OriginType> types;
	private String value;
	
	public List<OriginType> getTypes() {
		return types;
	}

	public void setTypes(List<OriginType> types) {
		this.types = types;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public static List<OriginOrigin> getValues(OriginType type) {
		ArrayList<OriginOrigin> ls = new ArrayList<OriginOrigin>();
		for (OriginOrigin origin: values()) {
			for (OriginType et: origin.getTypes()) {
				if (et == type) {
					ls.add(origin);
					break;
				}
			}
		}
		return ls;
	}

	OriginOrigin (List<OriginType> types, String value) {
		setTypes(types);
		setValue(value);
	}
	
	@Override
	public String toString() {
		return getValue();
	}
}
