package com.cogentautomation.model.enumerator.hazard;

import java.io.Serializable;

import com.cogentautomation.model.enumerator.hazard.generic.GenericConsequence;
import com.cogentautomation.model.enumerator.hazard.generic.GenericOrigin;
import com.cogentautomation.model.enumerator.hazard.generic.GenericType;
import com.cogentautomation.model.enumerator.hazard.origin.OriginConsequence;
import com.cogentautomation.model.enumerator.hazard.origin.OriginOrigin;
import com.cogentautomation.model.enumerator.hazard.origin.OriginType;

public class OriginHazard extends GenericHazard implements GenericHazardInterface, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OriginType type = null;
	private OriginOrigin origin = null;
	private OriginConsequence consequence = null;
	
	public OriginHazard (OriginType type, OriginOrigin origin, OriginConsequence consequence) {
		setType(type);
		setOrigin(origin);
		setConsequence(consequence);
	}
	public GenericType getType() {
		return type;
	}
	public void setType(GenericType type) {
		this.type = (OriginType) type;
	}
	/*public List<GenericOrigin> getOrigins(GenericType type) {
		List<OriginOrigin> array = OriginOrigin.getValues((OriginType) type);
	}*/
	public GenericOrigin getOrigin() {
		return origin;
	}
	public void setOrigin(GenericOrigin origin) {
		for (OriginType types: ((OriginOrigin) origin).getTypes()) {
			if (types == type) {
				this.origin = (OriginOrigin) origin;
				break;
			}
		}
	}
	/*public List<GenericConsequence> getConsequences(GenericType type, GenericOrigin origin) {
		List<OriginConsequence> array = OriginConsequence.getValues((OriginType) type, (OriginOrigin)origin);
	}*/
	public GenericConsequence getConsequence() {
		return consequence;
	}
	public void setConsequence(GenericConsequence consequence) {
		for (OriginOrigin types: ((OriginConsequence) consequence).getOrigins()) {
			if (types == origin) {
				this.consequence = (OriginConsequence) consequence;
			};
		}
	}
	public String toString() {
		return getConsequence().toString();
	}
}
