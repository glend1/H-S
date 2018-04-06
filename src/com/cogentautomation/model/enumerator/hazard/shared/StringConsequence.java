package com.cogentautomation.model.enumerator.hazard.shared;

import java.io.Serializable;

import com.cogentautomation.model.enumerator.hazard.generic.GenericConsequence;

public class StringConsequence implements GenericConsequence, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String consequence;
	
	public StringConsequence(String con) {
		setConsequence(con);
	}
	
	public StringConsequence() {
	}

	public String getConsequence() {
		return consequence;
	}

	public void setConsequence(String consequence) {
		this.consequence = consequence;
	}
	
	public String toString() {
		return consequence;
	}

}
