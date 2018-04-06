package com.cogentautomation.model;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Zone implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name = null;
	private CustomImage image = new CustomImage(null); 
	private String description = null;
	private Hazards hazards = new Hazards();
	public CustomImage getImage() {
		return image;
	}
	public void setImage(ImageIcon i) {
		image = new CustomImage(i);
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String d) {
		description = d;
	}
	public Hazards getHazards() {
		return hazards;
	}
	public String getName() {
		return name;
	}
	public void setName(String n) {
		name = n;
	}
	public String toString() {
		return getName();
	}
}
