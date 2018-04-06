package com.cogentautomation.controller;

import java.awt.Dimension;

import javax.swing.ImageIcon;

public class ImageResize {
	public static ImageIcon resize(double max, ImageIcon img) {		
		double width = img.getIconWidth();
		double height = img.getIconHeight();
		double perc = max / width;
		if (Math.floor(perc * height) > max) {
			perc = max / height;
		}
		int newWidth = (int) Math.floor(perc * width);
		int newHeight = (int) Math.floor(perc * height);
		
		return new ImageIcon(img.getImage().getScaledInstance(newWidth, newHeight, 0));
	}
	
	public static Dimension getWidth(double max, ImageIcon img) {
		double width = img.getIconWidth();
		double height = img.getIconHeight();
		double perc = max / width;
		int newWidth = (int) Math.floor(perc * width);
		int newHeight = (int) Math.floor(perc * height);
		return new Dimension(newWidth, newHeight);
	}
	
	public static Dimension getHeight(double max, ImageIcon img) {
		double width = img.getIconWidth();
		double height = img.getIconHeight();
		double perc = max / height;
		int newWidth = (int) Math.floor(perc * width);
		int newHeight = (int) Math.floor(perc * height);
		return new Dimension(newWidth, newHeight);
	}

	public static Dimension getDimensions(Dimension dimension, ImageIcon icon) {
		Dimension width = getWidth(dimension.getWidth(), icon);
		Dimension height = getHeight(dimension.getHeight(), icon);
		if (width.getWidth() < height.getWidth()) {
			return width;
		} else {
			return height;
		}
	}
	
}
