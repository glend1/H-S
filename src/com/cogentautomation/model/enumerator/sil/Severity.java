package com.cogentautomation.model.enumerator.sil;

import java.io.Serializable;

public enum Severity implements Serializable {
	S1("S1", "Slight (normally reversible injury)"), S2("S2", "Serious (normally irreversible injury or death)");
	
	private String print;
	private String display;
	
	Severity (String print, String display) {
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
