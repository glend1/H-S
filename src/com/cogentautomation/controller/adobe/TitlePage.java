package com.cogentautomation.controller.adobe;

import java.awt.Dimension;

import javax.swing.ImageIcon;

import org.pdfclown.documents.Document;
import org.pdfclown.documents.PageFormat.OrientationEnum;
import org.pdfclown.documents.contents.composition.XAlignmentEnum;
import org.pdfclown.documents.contents.composition.YAlignmentEnum;

import com.cogentautomation.model.Data;

public class TitlePage extends GenericAdobe {
	public TitlePage(Data data, Document document) {
		super(data, document);
	}

	public void make() {
		newPage(OrientationEnum.Portrait);
		newBlock(XAlignmentEnum.Center, YAlignmentEnum.Middle);
		
		setFont(true, 24);
		
		logo = new ImageIcon(getClass().getResource("/com/cogentautomation/logo.jpg"));
		showImage(new Dimension(248, 73), logo);
        /*image = Image.get(logo);
        imageXObject = image.toXObject(document);
        blockComposer.showXObject(imageXObject, new Dimension(248, 73));*/
        
        blockComposer.showBreak(lineBreak);
        blockComposer.showText("Risk Assessment");
        blockComposer.showBreak(lineBreak);
        
		showImage(new Dimension(avWidth / 2, 200), data.getClient().getImage());
		
		if (nullCheck(data.getProjectNumber())) {
			blockComposer.showBreak(lineBreak);
	        blockComposer.showText("Project Number: " + data.getProjectNumber());
		};
		
        endBlock(true);
	}
}
