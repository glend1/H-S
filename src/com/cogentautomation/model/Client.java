package com.cogentautomation.model;

import java.io.Serializable;

import javax.swing.ImageIcon;

import com.cogentautomation.model.shared.ContactInfo;

public class Client extends ContactInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CustomImage image = new CustomImage(null); 
	public CustomImage getImage() {
		return image;
	}
	public void setImage(ImageIcon i) {
		image = new CustomImage(i);
	}
}
