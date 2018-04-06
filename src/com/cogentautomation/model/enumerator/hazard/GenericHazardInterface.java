package com.cogentautomation.model.enumerator.hazard;

import com.cogentautomation.model.enumerator.HazardSelection;
import com.cogentautomation.model.enumerator.hazard.generic.GenericConsequence;
import com.cogentautomation.model.enumerator.hazard.generic.GenericOrigin;
import com.cogentautomation.model.enumerator.hazard.generic.GenericType;

public interface GenericHazardInterface {
	public void setHazard(HazardSelection hazardSelection);
	public HazardSelection getHazard();
	
	public GenericType getType();
	public void setType(GenericType type);
	public GenericOrigin getOrigin();
	public void setOrigin(GenericOrigin origin);
	public GenericConsequence getConsequence();
	public void setConsequence(GenericConsequence consequence);
	public String toString();
}
