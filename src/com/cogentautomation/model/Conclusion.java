package com.cogentautomation.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Conclusion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String conclusion;
	private ArrayList<CustomImage> images = new ArrayList<CustomImage>();
	public ArrayList<CustomImage> getImages() {
		return images;
	}
	public void setImages(ArrayList<CustomImage> images) {
		this.images = images;
	}
	public String getConclusion() {
		return conclusion;
	}
	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
	public String toString() {
		return "Conclusion";
	}
	public int getIndex(CustomImage img) {
		int val = -1;
		for (int i = 0; i < getImages().size(); i++) {
			if (getImages().get(i) == img) {
				val = i;
				break;					
			}
		}
		return val;
	}
	public void addImage(CustomImage img) {
		images.add(img);
	}
	public void updateImage(CustomImage img, CustomImage newImg) {
		int val = getIndex(img);
		if (val != -1) {
			getImages().set(val, newImg);
		}
	}
	public void deleteImage(CustomImage img) {
		int val = getIndex(img);
		if (val != -1) {
			getImages().remove(val);
		}
	}
}
