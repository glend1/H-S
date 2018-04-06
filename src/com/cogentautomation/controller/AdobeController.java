package com.cogentautomation.controller;

import com.cogentautomation.controller.adobe.GenericAdobe;
import com.cogentautomation.model.Data;

import java.io.IOException;

import org.pdfclown.documents.Document;
import org.pdfclown.files.File;
import org.pdfclown.files.SerializationModeEnum;

public class AdobeController {
	
	private File file;
	private java.io.File outFile;
    private Document document;
	
	public void write(Data data, String path) throws NullPointerException {
		
		if (!path.endsWith(".pdf")) {
			path = path + ".pdf";
		}
		file = new File();
		outFile = new java.io.File(path);
		document = file.getDocument();
		
		GenericAdobe ga = new GenericAdobe(data, document);
		
		ga.write();
		
		try {
			file.save(
					outFile,
					SerializationModeEnum.Standard
					);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
