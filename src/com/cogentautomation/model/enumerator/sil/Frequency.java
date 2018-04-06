package com.cogentautomation.model.enumerator.sil;

import java.io.Serializable;

public enum Frequency implements Serializable {
	F1("F1", "Seldom to less often and/or the exposure time is short"), F2("F2", "Frequent to continuous and/or the exposure time is long");	
	
	private String print;
	private String display;
	
	Frequency (String print, String display) {
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
