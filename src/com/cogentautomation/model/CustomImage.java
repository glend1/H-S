package com.cogentautomation.model;

import java.io.File;
import java.io.Serializable;

import javax.swing.ImageIcon;

import com.cogentautomation.controller.ImageIconToBuffer;

public class CustomImage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private byte[] data;
	private int width;
	private int height;
	private String filename;
	public CustomImage(ImageIcon img) {
		setImage(img);
	}
	public byte[] getImageBytes() {
		return data;
	}
	public ImageIcon getImage() {
		return ImageIconToBuffer.BytesToIcon(data);
	}
	public void setImage(ImageIcon data) {
		if (data != null) {
			setHeight(data.getIconHeight());
			setWidth(data.getIconWidth());
			File file = new File(data.toString());
			setFilename(file.getName());
			this.data = ImageIconToBuffer.IconToBytes(data);
		};
	}
	public int getWidth() {
		return width;
	}
	private void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	private void setHeight(int height) {
		this.height = height;
	}
	public String getFilename() {
		return filename;
	}
	private void setFilename(String filename) {
		this.filename = filename;
	}
}
