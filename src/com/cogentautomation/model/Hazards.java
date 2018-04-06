package com.cogentautomation.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.cogentautomation.model.enumerator.hazard.GenericHazard;

public class Hazards implements Serializable { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<GenericHazard> hazards = new ArrayList<GenericHazard>();
	public void newHazard(GenericHazard h) {
		hazards.add(h);
	}
	public void removeHazard(GenericHazard h) {
		hazards.remove(h);
	}
	public ArrayList<GenericHazard> getHazards() {
		return hazards;
	}
}
