package com.cogentautomation.controller;

import java.util.Comparator;

import com.cogentautomation.model.enumerator.hazard.GenericHazard;

public class HazardComparator implements Comparator<GenericHazard>
{
	@Override
	public int compare(GenericHazard gh0, GenericHazard gh1) {
		return gh1.getHazardDetails().getPre().getScore().compareTo(gh0.getHazardDetails().getPre().getScore());
	}
}
