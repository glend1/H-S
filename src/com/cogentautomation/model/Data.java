package com.cogentautomation.model;

import java.io.Serializable;

public class Data implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Client client = new Client();
	private People people = new People();
	private Machines machines = new Machines();
	private String projectNumber = null;
	private String motivation = null;
	private Conclusion conclusion = new Conclusion();
	public Client getClient() {
		return client;
	}
	public People getPeople() {
		return people;
	}
	public Machines getMachines() {
		return machines;
	}
	public String getProjectNumber() {
		return projectNumber;
	}
	public void setProjectNumber(String pn) {
		projectNumber = pn;
	}
	public String getMotivation() {
		return motivation;
	}
	public void setMotivation(String m) {
		motivation = m;
	}
	public String toString() {
		return "Client & General";
	}
	public Conclusion getConclusion() {
		return conclusion;
	}
	public void setConclusion(Conclusion conclusion) {
		this.conclusion = conclusion;
	}
}
