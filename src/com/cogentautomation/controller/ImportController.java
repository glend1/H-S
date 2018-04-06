package com.cogentautomation.controller;

import com.cogentautomation.view.ViewFileChooser;

public class ImportController {
	
	private ViewFileChooser fileChooser;
	
	public ImportController() {
		fileChooser = new ViewFileChooser("Open");
	}

	public ViewFileChooser getFileChooser() {
		return fileChooser;
	}

	public void setFileChooser(ViewFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}
	

}
