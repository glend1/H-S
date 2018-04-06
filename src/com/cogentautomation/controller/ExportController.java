package com.cogentautomation.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;

import com.cogentautomation.controller.listeners.FileListener;
import com.cogentautomation.model.Data;
import com.cogentautomation.view.ViewFileChooser;

public class ExportController {
	private ViewFileChooser fileChooser;
	
	public ExportController() {
		fileChooser = new ViewFileChooser("Save");
	}
	
	public void Save(Data data, JFrame frame) { 
		fileChooser.setVisible(true);
	
		fileChooser.setFileListener(new FileListener() {
			@Override
			public void fileEmitted(File file) {
				FileOutputStream fileOut;
				try {
					if (!file.getAbsolutePath().endsWith(".msa")) {
						file = new File(file + ".msa");
					}
					frame.setTitle("Machinery Safety Assessment - " + file);
					fileOut = new FileOutputStream(file);
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					out.writeObject(data);
					out.close();
					fileOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	
	}

}
