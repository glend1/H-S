package com.cogentautomation.controller.listeners;

import com.cogentautomation.model.enumerator.hazard.GenericHazard;

public interface HazardListener {
	public void hazardEmitted(GenericHazard hazard);
}

