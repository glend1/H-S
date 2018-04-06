package com.cogentautomation.model.enumerator.hazard;

import java.io.Serializable;

import com.cogentautomation.model.HazardDetails;
import com.cogentautomation.model.enumerator.HazardSelection;

public abstract class GenericHazard implements GenericHazardInterface, Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HazardDetails hazardDetails = new HazardDetails();
	private HazardSelection hazardSelection = HazardSelection.NOTCONSIDERED;

	@Override
	public void setHazard(HazardSelection hazardSelection) {
		this.hazardSelection = hazardSelection;
		
	}

	@Override
	public HazardSelection getHazard() {
		return this.hazardSelection;
	}
	
	public boolean compareTo(GenericHazard genericHazard) {
		switch (getClass().getSimpleName()) {
			case "OriginHazard":
				if (getConsequence() != genericHazard.getConsequence()) {
					return false;
				};
			case "EventHazard":
			case "TaskHazard":
				if (getType() != genericHazard.getType()) {
					return false;
				};
				if (getOrigin() != genericHazard.getOrigin()) {
					return false;
				};
				return true;
			default:
				break;
		}
		return false;
	}

	public HazardDetails getHazardDetails() {
		return hazardDetails;
	}

	public void setHazardDetails(HazardDetails hazardDetails) {
		this.hazardDetails = hazardDetails;
	}

}
