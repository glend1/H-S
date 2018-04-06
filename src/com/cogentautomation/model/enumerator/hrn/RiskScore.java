package com.cogentautomation.model.enumerator.hrn;

import java.io.Serializable;

public enum RiskScore implements Serializable {
	NEGLIGIBLE("Negligible", "Accept the risk.", ColourCode.GREEN), 
	V_L_RISK("Very low risk", "Address and remediate within 8 months.", ColourCode.GREEN),
	L_RISK("Low Risk", "Address and remediate within 4 months", ColourCode.GREEN),
	SIGNIFICANT("Significant", "Address and remediate within 1 months.", ColourCode.GREEN),
	HIGH("High", "Address and remediate within 2 weeks - Consider the use of temporary measures until remediation is carried out.", ColourCode.GREEN),
	V_HIGH("Very High", "Address and remediate within 3 days - Use temporary measures until remediation is carried out.", ColourCode.AMBER), 
	EXTREME("Extreme", "Address and remediate within 1 day - Mitigate the risk from any immediate hazard.", ColourCode.RED), 
	UNACCEPTABLE("Unacceptable", "Address and remediate immediately.", ColourCode.RED);
	
	private String description;
	private String longDescription;
	private ColourCode colour;
	
	RiskScore (String d, String ld, ColourCode c) {
		setDescription(d);
		setLongDescription(ld);
		setColour(c);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public ColourCode getColour() {
		return colour;
	}

	public void setColour(ColourCode colour) {
		this.colour = colour;
	}
	
	public static RiskScore getRisk(Double score) {
		if (score <= 10.0) {
			return NEGLIGIBLE;
		} else if (score <= 20.0) {
			return V_L_RISK;
		} else if (score <= 45.0) {
			return L_RISK;
		} else if (score <= 160.0) {
			return SIGNIFICANT;
		} else if (score <= 300.0) {
			return HIGH;
		} else if (score <= 500.0) {
			return V_HIGH;
		} else if (score <= 1000.0) {
			return EXTREME;
		} else if (score >= 1001.0) {
			return UNACCEPTABLE;
		} else {
			return null;
		}
	}
}
