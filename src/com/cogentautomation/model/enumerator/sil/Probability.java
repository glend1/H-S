package com.cogentautomation.model.enumerator.sil;

import java.io.Serializable;

public enum Probability implements Serializable {
	P1("P1", "Possible under specific conditions"), P2("P2", "Scarcely possible");
	
	private String print;
	private String display;
	
	Probability (String print, String display) {
		setPrint(print);
		setDisplay(display);
	}
	
	private void setPrint(String str) {
		print = str;
	}
	
	public String getPrint() {
		return print;
	}
	
	private void setDisplay(String str) {
		display = str;
	}
	
	public String getDisplay() {
		return display;
	}
	
	public String toString() {
		return getDisplay();
	}
}
