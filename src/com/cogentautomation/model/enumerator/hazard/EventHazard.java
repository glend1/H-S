package com.cogentautomation.model.enumerator.hazard;

import java.io.Serializable;

import com.cogentautomation.model.enumerator.hazard.event.EventOrigin;
import com.cogentautomation.model.enumerator.hazard.event.EventType;
import com.cogentautomation.model.enumerator.hazard.generic.GenericConsequence;
import com.cogentautomation.model.enumerator.hazard.generic.GenericOrigin;
import com.cogentautomation.model.enumerator.hazard.generic.GenericType;
import com.cogentautomation.model.enumerator.hazard.shared.StringConsequence;

public class EventHazard extends GenericHazard implements GenericHazardInterface, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EventType type = null;
	private EventOrigin origin = null;
	private StringConsequence consequence = new StringConsequence();
	
	public EventHazard (GenericType type, GenericOrigin origin) {
		setType(type);
		setOrigin(origin);
	}
	public GenericType getType() {
		return type;
	}
	public void setType(GenericType type) {
		this.type = (EventType) type;
	}
	/*public List<EventOrigin> getOrigins(EventType type) {
		return EventOrigin.getValues(type);
	}*/
	public GenericOrigin getOrigin() {
		return origin;
	}
	public void setOrigin(GenericOrigin origin) {
		for (EventType types: ((EventOrigin) origin).getTypes()) {
			if (types == type) {
				this.origin = (EventOrigin) origin;
				break;
			}
		}
	}
	public GenericConsequence getConsequence() {
		return consequence;
	}
	public void setConsequence(GenericConsequence consequence) {
		if (origin != null) {
			this.consequence = (StringConsequence) consequence;
		}
	}
	public String toString() {
		return getOrigin().toString();
	}
}