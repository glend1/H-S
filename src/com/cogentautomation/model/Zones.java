package com.cogentautomation.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Zones implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Zone> zones = new ArrayList<Zone>();
	public ArrayList<Zone> getZones() {
		return zones;
	}
	public void newZone(Zone zone) {
		zones.add(zone);
	}
	public void removeZone(Zone zone) {
		zones.remove(zone);
	}
}
