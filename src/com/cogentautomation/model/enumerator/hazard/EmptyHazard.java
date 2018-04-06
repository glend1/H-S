package com.cogentautomation.model.enumerator.hazard;

import java.io.Serializable;

import com.cogentautomation.model.enumerator.hazard.generic.GenericConsequence;
import com.cogentautomation.model.enumerator.hazard.generic.GenericOrigin;
import com.cogentautomation.model.enumerator.hazard.generic.GenericType;

public class EmptyHazard extends GenericHazard implements GenericHazardInterface, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public GenericType getType() {
		return null;
	}

	@Override
	public void setType(GenericType type) {
	}

	@Override
	public GenericOrigin getOrigin() {
		return null;
	}

	@Override
	public void setOrigin(GenericOrigin origin) {
	}

	@Override
	public GenericConsequence getConsequence() {
		return null;
	}

	@Override
	public void setConsequence(GenericConsequence consequence) {
	}

}
