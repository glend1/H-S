package com.cogentautomation.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Machines implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Machine> machines = new ArrayList<Machine>();
	public Machines() {
		newMachine(new Machine());
	}
	public ArrayList<Machine> getMachines() {
		return machines;
	}
	public void newMachine(Machine machine) {
		machines.add(machine);
	}
	public void removeMachine(Machine machine) {
		machines.remove(machine);
	}
	public Machine getMachine() {
		for (Machine machine : machines) {
			return machine;
		}
		return null;
	}
}
