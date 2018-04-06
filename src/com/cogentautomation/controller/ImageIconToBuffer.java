package com.cogentautomation.controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.swing.ImageIcon;

import org.pdfclown.bytes.Buffer;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageIconToBuffer {
	public static Buffer convert(ImageIcon img) {
		Buffer buffer = new Buffer(IconToBytes(img));
		return buffer;
	}
	
	public static Buffer toBuffer(byte[] img) {
		Buffer buffer = new Buffer(img);
		return buffer;
	}
	
	public static byte[] toByteArray(BufferedImage image) {
	    try {
	    	ByteArrayOutputStream baos = new ByteArrayOutputStream();            
	    	JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(baos);
			encoder.encode(image);
			return baos.toByteArray();
		} catch (Exception e) {
		}   
	    return null;
	}
	
	public static BufferedImage toBufferedImage(ImageIcon icon) {
		Image img = icon.getImage();
		BufferedImage bi = new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_INT_RGB);
		
		Graphics2D bGr = bi.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();
	    
	    return bi;
	}
	
	public static byte[] IconToBytes(ImageIcon img) {
		BufferedImage image = toBufferedImage(img);
	    return toByteArray(image);
	}
	
	public static ImageIcon BytesToIcon(byte[] img) {
		if (img == null) {
			return null;
		} else {
			return new ImageIcon(img);
		}
	}
	
}
