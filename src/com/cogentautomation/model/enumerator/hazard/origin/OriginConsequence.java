package com.cogentautomation.model.enumerator.hazard.origin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cogentautomation.model.enumerator.hazard.generic.GenericConsequence;

public enum OriginConsequence implements GenericConsequence, Serializable {

	RUNOVER(Arrays.asList(OriginType.MECHANICAL), Arrays.asList(OriginOrigin.OTHER), "Being Run Over"),
	THROWN(Arrays.asList(OriginType.MECHANICAL), Arrays.asList(OriginOrigin.OTHER), "Being Thrown"),
	CRUSHING(Arrays.asList(OriginType.MECHANICAL), Arrays.asList(OriginOrigin.OTHER), "Crushing"),
	CUTTING(Arrays.asList(OriginType.MECHANICAL), Arrays.asList(OriginOrigin.OTHER), "Cutting or Severing"),
	TRAPPING(Arrays.asList(OriginType.MECHANICAL), Arrays.asList(OriginOrigin.OTHER), "Drawing-in or Trapping"),
	ENTANGLEMENT(Arrays.asList(OriginType.MECHANICAL), Arrays.asList(OriginOrigin.OTHER), "Entanglement"),
	FRICTION(Arrays.asList(OriginType.MECHANICAL), Arrays.asList(OriginOrigin.OTHER), "Friction or Abrasion"),
	IMPACT(Arrays.asList(OriginType.MECHANICAL), Arrays.asList(OriginOrigin.OTHER), "Impact"),
	INJECTION(Arrays.asList(OriginType.MECHANICAL), Arrays.asList(OriginOrigin.OTHER), "Injection"),
	SHEARING(Arrays.asList(OriginType.MECHANICAL), Arrays.asList(OriginOrigin.OTHER), "Shearing"),
	STABBING(Arrays.asList(OriginType.MECHANICAL), Arrays.asList(OriginOrigin.OTHER), "Stabbing or Puncturing"),
	
	CHEMICAL(Arrays.asList(OriginType.ELECTRICAL), Arrays.asList(OriginOrigin.OTHER), "Chemical Effects"),
	MEDICALIMPLANTS(Arrays.asList(OriginType.ELECTRICAL), Arrays.asList(OriginOrigin.OTHER), "Effects on Medical Implants"),
	ELECTROCUTION(Arrays.asList(OriginType.ELECTRICAL), Arrays.asList(OriginOrigin.OTHER), "Electrocution"),
	FALLING(Arrays.asList(OriginType.ELECTRICAL), Arrays.asList(OriginOrigin.OTHER), "Falling or Being Thrown"),
	MOLTENPARTICLES(Arrays.asList(OriginType.ELECTRICAL), Arrays.asList(OriginOrigin.OTHER), "Projection of Molten Particles"),
	SHOCK(Arrays.asList(OriginType.ELECTRICAL), Arrays.asList(OriginOrigin.OTHER), "Shock"),
	
	DEHYDRATION(Arrays.asList(OriginType.THERMAL), Arrays.asList(OriginOrigin.OTHER), "Dehydration"),
	FROSTBITE(Arrays.asList(OriginType.THERMAL), Arrays.asList(OriginOrigin.OTHER), "Frostbite"),
	RADIATEDHEAT(Arrays.asList(OriginType.THERMAL), Arrays.asList(OriginOrigin.OTHER), "Injuries from Radiated Heat"),
	SCALD(Arrays.asList(OriginType.THERMAL), Arrays.asList(OriginOrigin.OTHER), "Scald"),
	
	AWARENESS(Arrays.asList(OriginType.NOISE), Arrays.asList(OriginOrigin.OTHER), "Loss of Awareness"),
	BALANCE(Arrays.asList(OriginType.NOISE), Arrays.asList(OriginOrigin.OTHER), "Loss of Balance"),
	HEARINGLOSS(Arrays.asList(OriginType.NOISE), Arrays.asList(OriginOrigin.OTHER), "Permanent Hearing Loss"),
	TINNITUS(Arrays.asList(OriginType.NOISE), Arrays.asList(OriginOrigin.OTHER), "Tinnitus"),
	TIREDNESS(Arrays.asList(OriginType.NOISE), Arrays.asList(OriginOrigin.OTHER), "Tiredness"),
	
	LOWBACK(Arrays.asList(OriginType.VIBRATION), Arrays.asList(OriginOrigin.OTHER), "Low-back Disease"),
	NEUROLOGICAL(Arrays.asList(OriginType.VIBRATION), Arrays.asList(OriginOrigin.OTHER), "Neurological Disorder"),
	OSTEOARTICULAR(Arrays.asList(OriginType.VIBRATION), Arrays.asList(OriginOrigin.OTHER), "Osteo-articular Disorder"),
	SPINETRAUMA(Arrays.asList(OriginType.VIBRATION), Arrays.asList(OriginOrigin.OTHER), "Trauma of the Spine"),
	VASCULAR(Arrays.asList(OriginType.VIBRATION), Arrays.asList(OriginOrigin.OTHER), "Vascular Disorder"),
	
	EYESANDSKIN(Arrays.asList(OriginType.RADIATION), Arrays.asList(OriginOrigin.OTHER), "Damage to eyes and skin"),
	HEADACHE(Arrays.asList(OriginType.RADIATION), Arrays.asList(OriginOrigin.OTHER), "Headache, Insomnia, E.C.T."),
	
	CANCER(Arrays.asList(OriginType.MATERIAL), Arrays.asList(OriginOrigin.OTHER), "Cancer"),
	CORROSION(Arrays.asList(OriginType.MATERIAL), Arrays.asList(OriginOrigin.OTHER), "Corrosion"),
	EXPLOSION(Arrays.asList(OriginType.MATERIAL), Arrays.asList(OriginOrigin.OTHER), "Explosion"),
	INFECTION(Arrays.asList(OriginType.MATERIAL), Arrays.asList(OriginOrigin.OTHER), "Infection"),
	POISONING(Arrays.asList(OriginType.MATERIAL), Arrays.asList(OriginOrigin.OTHER), "Poisoning"),
	SENSITISATION(Arrays.asList(OriginType.MATERIAL), Arrays.asList(OriginOrigin.OTHER), "Sensitisation"),
	
	FATIGUE(Arrays.asList(OriginType.ERGONOMIC), Arrays.asList(OriginOrigin.OTHER), "Fatigue"),
	MUSCULOSKELETAL(Arrays.asList(OriginType.ERGONOMIC), Arrays.asList(OriginOrigin.OTHER), "Musculoskeletal Disorder"),
	
	DISEASE(Arrays.asList(OriginType.ENVIROMENTAL), Arrays.asList(OriginOrigin.OTHER), "Slight disease"),
	OTHER(Arrays.asList(OriginType.ENVIROMENTAL), Arrays.asList(), "Other", Arrays.asList(OriginOrigin.OTHER)),
	
	SLIPPING(Arrays.asList(OriginType.MECHANICAL, OriginType.ENVIROMENTAL), Arrays.asList(OriginOrigin.OTHER), "Slipping, Tripping or Falling"),
	OTHERNOISE(Arrays.asList(OriginType.NOISE, OriginType.ERGONOMIC), Arrays.asList(OriginOrigin.OTHER), "Other (E.G. Mechanical or Electrical)"),
	STRESS(Arrays.asList(OriginType.NOISE, OriginType.ERGONOMIC), Arrays.asList(OriginOrigin.OTHER), "Stress"),
	MUTATION(Arrays.asList(OriginType.RADIATION, OriginType.MATERIAL), Arrays.asList(OriginOrigin.OTHER), "Genetic Mutation"),
	FIRE(Arrays.asList(OriginType.ELECTRICAL, OriginType.MATERIAL), Arrays.asList(OriginOrigin.OTHER), "Fire"),
	REPRODUCTIVE(Arrays.asList(OriginType.RADIATION, OriginType.MATERIAL), Arrays.asList(OriginOrigin.OTHER), "Effects on Reproductive Capability"),
	SUFFOCATION(Arrays.asList(OriginType.MECHANICAL, OriginType.MATERIAL, OriginType.ENVIROMENTAL), Arrays.asList(OriginOrigin.OTHER), "Suffocation"),
	BURN(Arrays.asList(OriginType.ELECTRICAL, OriginType.THERMAL, OriginType.RADIATION, OriginType.ENVIROMENTAL), Arrays.asList(OriginOrigin.OTHER), "Burn"),
	DISCOMFORT(Arrays.asList(OriginType.THERMAL, OriginType.NOISE, OriginType.VIBRATION, OriginType.ERGONOMIC), Arrays.asList(OriginOrigin.OTHER), "Discomfort");
	 
	private List<OriginOrigin> origins;
	private List<OriginType> types;
	private String value;
	private List<OriginOrigin> exclude;
	private List<OriginOrigin> include = Arrays.asList();
	
	public static List<OriginOrigin> getOrigins(List<OriginType> list) {
		List<OriginOrigin> ls = new ArrayList<OriginOrigin>();
		for (OriginType ot: list) {
			for (OriginOrigin oo: OriginOrigin.getValues(ot)) {
				if (!ls.contains(oo)) {
					ls.add(oo);
				}
			}
		}
		return ls;
	}
	
	public List<OriginOrigin> getOrigins() {
		return origins;
	}

	public void setOrigins(List<OriginOrigin> origins) {
		this.origins = origins;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public static List<OriginConsequence> getValues(OriginType ot, OriginOrigin oo) {
		ArrayList<OriginConsequence> ls = new ArrayList<OriginConsequence>();
		for (OriginConsequence con: values()) {
			if ((con.getTypes().contains(ot) && con.getOrigins().contains(oo) && !con.getExclude().contains(oo)) || con.getInclude().contains(oo)) {
				ls.add(con);				
			}
		}
		return ls;
	}

	OriginConsequence (List<OriginType> types, List<OriginOrigin> exclude, String value) {
		setter(types, exclude, value);
	}
	
	OriginConsequence (List<OriginType> types, List<OriginOrigin> exclude, String value, List<OriginOrigin> include) {
		setter(types, exclude, value);
		setInclude(include);
	}

	private void setter(List<OriginType> types, List<OriginOrigin> exclude, String value) {
		setTypes(types);
		setOrigins(getOrigins(types));
		setExclude(exclude);
		setValue(value);		
	}

	@Override
	public String toString() {
		return getValue();
	}

	public List<OriginType> getTypes() {
		return types;
	}

	public void setTypes(List<OriginType> types) {
		this.types = types;
	}

	public List<OriginOrigin> getExclude() {
		return exclude;
	}

	public void setExclude(List<OriginOrigin> exclude) {
		this.exclude = exclude;
	}

	public List<OriginOrigin> getInclude() {
		return include;
	}

	public void setInclude(List<OriginOrigin> include) {
		this.include = include;
	}
}
